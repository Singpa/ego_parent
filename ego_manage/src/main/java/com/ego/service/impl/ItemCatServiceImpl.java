package com.ego.service.impl;

import com.ego.commons.pojo.EasyUITree;
import com.ego.dubbo.service.ItemCatDubboService;
import com.ego.pojo.ItemCat;
import com.ego.service.ItemCatService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ItemCatServiceImpl implements ItemCatService {
    @DubboReference
    private ItemCatDubboService itemCatDubboService;

    @Override
    public List<EasyUITree> selectItemCat(Long parentId) {
        List<ItemCat> itemCats = itemCatDubboService.selectItemByParentId(parentId);
        List<EasyUITree> easyUITrees = new ArrayList<>();
        for (ItemCat itemCat : itemCats) {
            EasyUITree easyUITree = new EasyUITree();
            easyUITree.setId(itemCat.getId());
            easyUITree.setText(itemCat.getName());
            easyUITree.setState(itemCat.getIsParent() ? "closed" : "open");
            easyUITrees.add(easyUITree);

        }
        return easyUITrees;
    }
}
