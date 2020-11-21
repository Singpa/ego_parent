package com.ego.dubbo.service;

import com.ego.commons.excption.DaoExcption;
import com.ego.pojo.Item;
import com.ego.pojo.ItemDesc;
import com.ego.pojo.ItemParamItem;

import java.util.List;

public interface ItemDubboService {
    /**
     * 分页查询
     *
     * @param pageSize 条数
     * @param pageNum  当前页面
     * @return
     */
    List<Item> selectItemByPage(int pageNum, int pageSize);

    /**
     * 查询总数
     *
     * @return
     */
    long selectItemTotal();

    /**
     * 改变商品状态/上架/下架
     *
     * @return
     */
    int updateStatusById(Long[] ids, int status) throws DaoExcption;

    /**
     * 存储item
     *
     * @param item
     * @param itemDesc
     * @return
     * @throws DaoExcption
     */
    int saveItem(Item item, ItemDesc itemDesc, ItemParamItem itemParamItem) throws DaoExcption;

    /**
     * 查询商品描述
     *
     * @param itemId
     * @return
     */
    ItemDesc selectItemDescByItemId(long itemId);

    /**
     * 更新商品
     *
     * @param item
     * @param itemDesc
     * @return
     */
    int updateItem(Item item, ItemDesc itemDesc, ItemParamItem itemParamItem) throws DaoExcption;
}
