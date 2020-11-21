package com.ego.dubbo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ego.commons.excption.DaoExcption;
import com.ego.dubbo.service.ItemDubboService;
import com.ego.mapper.ItemDescMapper;
import com.ego.mapper.ItemMapper;
import com.ego.mapper.ItemParamItemMapper;
import com.ego.pojo.Item;
import com.ego.pojo.ItemDesc;
import com.ego.pojo.ItemParamItem;
import org.apache.dubbo.config.annotation.DubboService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@DubboService
public class ItemDubboServiceImpl implements ItemDubboService {
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private ItemDescMapper itemDescMapper;
    @Autowired
    private ItemParamItemMapper itemParamItemMapper;

    @Override
    public List<Item> selectItemByPage(int pageNum, int pageSize) {
        Page<Item> page = new Page<>();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        Page<Item> itemPage = itemMapper.selectPage(page, null);
        return itemPage.getRecords();
    }

    @Override
    public long selectItemTotal() {
        return itemMapper.selectCount(null);
    }

    @Override
    @Transactional
    public int updateStatusById(Long[] ids, int status) throws DaoExcption {
        int count = 0;
        for (Long id : ids) {
            Item item = new Item();
            item.setId(id);
            item.setStatus(status);
            count += itemMapper.updateById(item);
        }
        if (count == ids.length) {
            return 1;
        }
        throw new DaoExcption("批量更新失败");
    }

    @Override
    @Transactional
    public int saveItem(Item item, ItemDesc itemDesc, ItemParamItem itemParamItem) throws DaoExcption {
        int insert = itemMapper.insert(item);
        if (insert == 1) {
            int i = itemDescMapper.insert(itemDesc);
            if (i == 1) {
                i = itemParamItemMapper.insert(itemParamItem);
                if (i == 1) {
                    return 1;
                }
            }
        }
        throw new DaoExcption("新增商品失败");
    }

    @Override
    public ItemDesc selectItemDescByItemId(long itemId) {

        return itemDescMapper.selectById(itemId);
    }

    @Override
    @Transactional
    public int updateItem(Item item, ItemDesc itemDesc, ItemParamItem itemParamItem) throws DaoExcption {
        int result = itemMapper.updateById(item);
        if (result == 1) {
            result = itemDescMapper.updateById(itemDesc);
            if (result == 1) {
                result = itemParamItemMapper.updateById(itemParamItem);
                if (result == 1) {
                    return 1;
                }
            }
        }
        throw new DaoExcption("修改商品失败");
    }
}
