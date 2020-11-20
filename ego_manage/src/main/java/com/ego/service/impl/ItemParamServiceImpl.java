package com.ego.service.impl;

import com.ego.commons.excption.DaoExcption;
import com.ego.commons.pojo.EasyUIDatagrid;
import com.ego.commons.pojo.EgoResult;
import com.ego.commons.utils.IDUtils;
import com.ego.dubbo.service.ItemParamDubboService;
import com.ego.pojo.ItemParam;
import com.ego.service.ItemParamService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ItemParamServiceImpl implements ItemParamService {
    @DubboReference
    private ItemParamDubboService itemParamDubboService;

    @Override
    public EasyUIDatagrid selectItemParamPage(int pageNum, int pageSize) {
        List<ItemParam> itemParams = itemParamDubboService.selectItemParamByPage(pageNum, pageSize);
        long total = itemParamDubboService.selectTotal();
        EasyUIDatagrid easyUIDatagrid = new EasyUIDatagrid(itemParams, total);
        return easyUIDatagrid;
    }

    @Override
    public EgoResult selectItemParamByItemCatId(Long itemCatId) {
        ItemParam itemParam = itemParamDubboService.selectItemParamByItemCatId(itemCatId);
        if (itemCatId != null) {
            return EgoResult.ok();
        }
        return EgoResult.error("查询失败");
    }

    @Override
    public EgoResult saveItemParam(Long itemCatId, String paramData) {
        Date now = new Date();
        ItemParam itemParam = new ItemParam();
        itemParam.setId(IDUtils.genItemId());
        itemParam.setItemCatId(itemCatId);
        itemParam.setParamData(paramData);
        itemParam.setCreated(now);
        itemParam.setUpdated(now);

        int i = itemParamDubboService.saveItemParam(itemParam);
        if (i == 1) {
            return EgoResult.ok();
        }
        return EgoResult.error("新增失败");
    }

    @Override
    public EgoResult deleteItemParam(Long[] ids) {
        try {
            int result = itemParamDubboService.deleteItemParams(ids);
            if (result == 1) {
                return EgoResult.ok();
            }
        } catch (DaoExcption excption) {
            excption.printStackTrace();
        }
        return EgoResult.error("删除失败");
    }
}
