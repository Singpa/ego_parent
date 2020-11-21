package com.ego.controller;

import com.ego.commons.pojo.EgoResult;
import com.ego.pojo.ItemParamItem;
import com.ego.service.ItemParamItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemParamItemController {

    @Autowired
    private ItemParamItemService itemParamItemService;

    @RequestMapping("/rest/item/param/item/query/{itemId}")
    public EgoResult selectItemParamItem(@PathVariable Long itemId) {
        return itemParamItemService.selectItemParamItemByItemId(itemId);
    }
}
