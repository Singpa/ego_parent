package com.ego.service.impl;

import com.ego.commons.pojo.EgoResult;
import com.ego.dubbo.service.ItemParamItemDubboService;
import com.ego.pojo.ItemParamItem;
import com.ego.service.ItemParamItemService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

@Service
public class ItemParamItemServiceImpl implements ItemParamItemService {
    @DubboReference
    private ItemParamItemDubboService itemParamItemDubboService;

    @Override
    public EgoResult selectItemParamItemByItemId(Long itemId) {
        ItemParamItem itemParamItem = itemParamItemDubboService.selectItemParamItemByItemId(itemId);
        if (itemParamItem != null) {
            return EgoResult.ok(itemParamItem);
        }
        return EgoResult.error("查询失败");
    }
}
