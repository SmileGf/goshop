package com.goshop.service;

import java.util.List;

import com.goshop.common.pojo.EUTreeNode;

public interface ItemCatService {

	List<EUTreeNode> getItemCatList(Long parentId) throws Exception;
}
