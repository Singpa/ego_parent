package com.ego.dubbo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ego.dubbo.service.ItemParamItemDubboService;
import com.ego.mapper.ItemParamItemMapper;
import com.ego.pojo.ItemParamItem;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService
public class ItemParamItemDubboServiceImpl implements ItemParamItemDubboService {
    @Autowired
    private ItemParamItemMapper itemParamItemMapper;

    @Override
    public ItemParamItem selectItemParamItemByItemId(Long itemId) {
        QueryWrapper<ItemParamItem> wrapper = new QueryWrapper<>();
        wrapper.eq("item_id", itemId);
        return itemParamItemMapper.selectOne(wrapper);
    }
}
