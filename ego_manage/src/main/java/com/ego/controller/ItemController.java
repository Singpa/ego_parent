package com.ego.controller;

import com.ego.commons.pojo.EasyUIDatagrid;
import com.ego.commons.pojo.EgoResult;
import com.ego.pojo.Item;
import com.ego.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUIDatagrid list(@RequestParam(value = "page", defaultValue = "1") int page,
                               @RequestParam(value = "rows", defaultValue = "30") int rows) {
        EasyUIDatagrid easyUIDatagrid = itemService.selectItenPage(page, rows);
        return easyUIDatagrid;
    }

    @RequestMapping("/rest/item/delete")
    @ResponseBody
    public EgoResult delete(Long[] ids) {
        return itemService.updateStatus(ids, 3);
    }

    @RequestMapping("/rest/item/instock")
    @ResponseBody
    public EgoResult instock(Long[] ids) {
        return itemService.updateStatus(ids, 2);
    }

    @RequestMapping("/rest/item/reshelf")
    @ResponseBody
    public EgoResult reshelf(Long[] ids) {
        return itemService.updateStatus(ids, 1);
    }

    @RequestMapping("/item/save")
    @ResponseBody
    public EgoResult save(Item item, String desc, String itemParams) {
        return itemService.saveItem(item, desc, itemParams);
    }

    @RequestMapping("/rest/page/item-edit")
    public String toItemEditPage() {
        return "item-edit";
    }

    @RequestMapping("/rest/item/query/item/desc/{itemId}")
    @ResponseBody
    public EgoResult getItemDesc(@PathVariable Long itemId) {
        return itemService.selectItemDesc(itemId);
    }

    @RequestMapping("/rest/item/update")
    @ResponseBody
    public EgoResult updateItem(Item item, String desc) {
        return itemService.updateItem(item, desc);
    }

    @RequestMapping("rest/item/param/item/query/{itemId}")
    @ResponseBody
    public EgoResult getUpdateItemParam(@PathVariable Long itemId) {
        return itemService.selectItemDesc(itemId);
    }


}
