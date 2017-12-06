package com.goshop.service;

import com.goshop.common.pojo.EUDataGridResult;
import com.goshop.pojo.TbItem;

/**
 * 商品管理
 * @author Administrator
 *
 */
public interface ItemService {
	
	TbItem getItemById(long itemId) throws Exception;
	
	EUDataGridResult getItemList(int page ,int rows) throws Exception;

}
