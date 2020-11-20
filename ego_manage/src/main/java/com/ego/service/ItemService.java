package com.ego.service;

import com.ego.commons.pojo.EasyUIDatagrid;
import com.ego.commons.pojo.EgoResult;
import com.ego.pojo.Item;
import com.ego.pojo.ItemDesc;

public interface ItemService {
    /**
     * 查询商品分页
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    EasyUIDatagrid selectItenPage(int pageNum, int pageSize);

    /**
     * 更新状态
     *
     * @param ids
     * @param status
     * @return
     */
    EgoResult updateStatus(Long[] ids, Integer status);

    /**
     * 新增item
     *
     * @param item
     * @return
     */
    EgoResult saveItem(Item item, String desc);

    /**
     * 查询商品描述信息
     *
     * @param itemId
     * @return
     */
    EgoResult selectItemDesc(Long itemId);

    /**
     * 修改商品信息
     *
     * @param item
     * @param desc
     * @return
     */
    EgoResult updateItem(Item item, String desc);
}
