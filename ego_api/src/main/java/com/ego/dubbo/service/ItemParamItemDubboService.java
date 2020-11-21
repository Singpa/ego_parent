package com.ego.dubbo.service;

import com.ego.pojo.ItemParamItem;

public interface ItemParamItemDubboService {
    /**
     * 根据商品id查询param
     * @param itemId
     * @return
     */
    ItemParamItem selectItemParamItemByItemId(Long itemId);
}
