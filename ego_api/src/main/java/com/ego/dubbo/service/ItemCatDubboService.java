package com.ego.dubbo.service;

import com.ego.pojo.ItemCat;

import java.util.List;

public interface ItemCatDubboService {
    /**
     * 根据父id查询父类目
     *
     * @param parentId
     * @return
     */
    List<ItemCat> selectItemByParentId(Long parentId);
}
