package com.goshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goshop.common.pojo.EUTreeNode;
import com.goshop.mapper.TbItemCatMapper;
import com.goshop.pojo.TbItemCat;
import com.goshop.pojo.TbItemCatExample;
import com.goshop.pojo.TbItemCatExample.Criteria;
import com.goshop.service.ItemCatService;

/**
 * 商品分类管理
 * @author Administrator
 *
 */

@Service
public class ItemCatServiceImpl implements ItemCatService{

	@Autowired
	private TbItemCatMapper  itemCatMapper;
	
	@Override
	public List<EUTreeNode> getItemCatList(Long parentId) throws Exception {
		TbItemCatExample example = new TbItemCatExample();
		//设置查询条件
		Criteria criteria = example.createCriteria();
		//根据parentid查询子节点
		criteria.andParentIdEqualTo(parentId);
		//返回子节点列表
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		List<EUTreeNode> resultList = new ArrayList<EUTreeNode>();
		//转换list
		for(TbItemCat itemCat : list){
			EUTreeNode treeNode = new EUTreeNode();
			treeNode.setId(itemCat.getId());
			treeNode.setText(itemCat.getName());
			treeNode.setState(itemCat.getIsParent() ? "closed":"open");
			resultList.add(treeNode);
		}
		return resultList;
	}

	
}
