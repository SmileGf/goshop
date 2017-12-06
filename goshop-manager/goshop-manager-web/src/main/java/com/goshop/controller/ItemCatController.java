package com.goshop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goshop.common.pojo.EUTreeNode;
import com.goshop.service.ItemCatService;

/**
 * 商品分类
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<EUTreeNode> categoryList(@RequestParam(value="id", defaultValue="0") Long parentId){
		List<EUTreeNode> list = new ArrayList<EUTreeNode>();
		try {
			 list = itemCatService.getItemCatList(parentId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
