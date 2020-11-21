package com.ego.controller;

import com.ego.commons.pojo.EasyUIDatagrid;
import com.ego.commons.pojo.EgoResult;
import com.ego.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemParamController {

    @Autowired
    private ItemParamService itemParamService;

    @RequestMapping("/item/param/list")
    public EasyUIDatagrid showItemParam(int page, int rows) {
        return itemParamService.selectItemParamPage(page, rows);
    }

    @RequestMapping("/item/param/query/itemcatid/{itemCatId}")
    public EgoResult checkItemParamExists(@PathVariable long itemCatId) {
        return itemParamService.selectItemParamByItemCatId(itemCatId);
    }

    @RequestMapping("/item/param/save/{itemCatId}")
    public EgoResult saveItemParam(@PathVariable long itemCatId, String paramData) {
        return itemParamService.saveItemParam(itemCatId, paramData);
    }

    @RequestMapping("/item/param/delete")
    public EgoResult deleteItemParem(Long[] ids) {
        return itemParamService.deleteItemParam(ids);
    }


}
