package com.ego.service;

import com.ego.commons.pojo.EgoResult;

public interface ItemParamItemService {
    /**
     * 根据id查询itemParam
     *
     * @param itemId
     * @return
     */
    EgoResult selectItemParamItemByItemId(Long itemId);
}
