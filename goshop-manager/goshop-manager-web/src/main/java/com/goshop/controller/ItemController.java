package com.goshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goshop.common.pojo.EUDataGridResult;
import com.goshop.pojo.TbItem;
import com.goshop.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId){
		TbItem tbItem =new TbItem();
		try {
			tbItem = itemService.getItemById(itemId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tbItem;
	}

	@RequestMapping("/item/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows) {
		EUDataGridResult result = new EUDataGridResult();
		try {
			result = itemService.getItemList(page, rows);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
