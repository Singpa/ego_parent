package com.ego.dubbo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ego.commons.excption.DaoExcption;
import com.ego.dubbo.service.ItemParamDubboService;
import com.ego.mapper.ItemParamMapper;
import com.ego.pojo.ItemParam;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@DubboService
public class ItemParamDubboServiceImpl implements ItemParamDubboService {

    @Autowired
    private ItemParamMapper itemParamMapper;

    @Override
    public List<ItemParam> selectItemParamByPage(int pageNum, int pageSize) {
        Page<ItemParam> page = new Page<>();
        Page<ItemParam> paramPage = itemParamMapper.selectPage(page, null);
        return paramPage.getRecords();

    }

    @Override
    public long selectTotal() {
        return itemParamMapper.selectCount(null);
    }

    @Override
    public ItemParam selectItemParamByItemCatId(long itemCatId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("item_cat_id", itemCatId);
        return itemParamMapper.selectOne(queryWrapper);
    }

    @Override
    public int saveItemParam(ItemParam itemParam) {
        return itemParamMapper.insert(itemParam);
    }

    @Override
    //@Transactional
    public int deleteItemParams(long[] ids) throws DaoExcption {
        int result = itemParamMapper.deleteBatchIds(Arrays.asList(ids));
        if (result == ids.length) {
            return 1;
        }
        throw new DaoExcption("批量删除失败");
    }

    @Override
    public int deleteItemParam(long itemParamId) throws DaoExcption {
        return itemParamMapper.deleteById(itemParamId);
    }

}
