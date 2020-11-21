package com.ego.controller;

import com.ego.commons.pojo.EasyUITree;
import com.ego.commons.pojo.EgoResult;
import com.ego.service.ItemCatService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/item/cat/list")
    @ResponseBody
    public List<EasyUITree> showItem(@RequestParam(value = "id", defaultValue = "0") Long id) {
        return itemCatService.selectItemCat(id);
    }

    @RequestMapping("/item/cat/query/id/{id}")
    @ResponseBody
    public EgoResult selectItemParamById(@PathVariable Long id) {
        return itemCatService.selectItemCatById(id);

    }
}
