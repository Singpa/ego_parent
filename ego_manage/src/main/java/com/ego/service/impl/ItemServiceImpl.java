package com.ego.service.impl;

import com.ego.commons.excption.DaoExcption;
import com.ego.commons.pojo.EasyUIDatagrid;
import com.ego.commons.pojo.EgoResult;
import com.ego.commons.utils.IDUtils;
import com.ego.dubbo.service.ItemDubboService;
import com.ego.pojo.Item;
import com.ego.pojo.ItemDesc;
import com.ego.service.ItemService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ItemServiceImpl implements ItemService {

    @DubboReference
    private ItemDubboService itemDubboService;

    @Override
    public EasyUIDatagrid selectItenPage(int pageNum, int pageSize) {
        EasyUIDatagrid easyUIDatagrid = new EasyUIDatagrid();
        easyUIDatagrid.setRows(itemDubboService.selectItemByPage(pageNum, pageSize));
        easyUIDatagrid.setTotal(itemDubboService.selectItemTotal());
        return easyUIDatagrid;
    }

    @Override
    public EgoResult updateStatus(Long[] ids, Integer status) {
        try {
            int i = itemDubboService.updateStatusById(ids, status);
            return EgoResult.ok();
        } catch (DaoExcption excption) {
            excption.printStackTrace();
            return EgoResult.error("更新状态失败");
        }

    }

    @Override
    public EgoResult saveItem(Item item, String desc) {
        Long itemId = IDUtils.genItemId();
        Date date = new Date();
        item.setId(itemId);
        item.setUpdated(date);
        item.setCreated(date);
        ItemDesc itemDesc = new ItemDesc();
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setUpdated(date);
        itemDesc.setCreated(date);
        try {
            int i = itemDubboService.saveItem(item, itemDesc);
            return EgoResult.ok();
        } catch (DaoExcption excption) {
            excption.printStackTrace();
        }
        return EgoResult.error("新增失败");
    }

    @Override
    public EgoResult selectItemDesc(Long itemId) {
        ItemDesc itemDesc = itemDubboService.selectItemDescByItemId(itemId);
        if (itemDesc != null) {
            return EgoResult.ok(itemDesc);
        }
        return EgoResult.error("查询失败");
    }
}
