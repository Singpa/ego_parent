package com.ego.service;

import com.ego.commons.pojo.EasyUITree;
import com.ego.pojo.ItemCat;

import java.util.List;

public interface ItemCatService {
    List<EasyUITree> selectItemCat(Long parentId);
}
