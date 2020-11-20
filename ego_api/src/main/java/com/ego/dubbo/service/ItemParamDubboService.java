package com.ego.dubbo.service;

import com.ego.commons.excption.DaoExcption;
import com.ego.pojo.ItemParam;

import java.util.List;

public interface ItemParamDubboService {
    /**
     * 分页查询商品参数
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<ItemParam> selectItemParamByPage(int pageNum, int pageSize);

    /**
     * 查询分页总数
     *
     * @return
     */
    long selectTotal();

    /**
     * 根据商品id查询商品规格
     *
     * @return
     */
    ItemParam selectItemParamByItemCatId(long itemCatId);

    /**
     * 保存商品规格
     *
     * @return
     */
    int saveItemParam(ItemParam itemParam);

    /**
     * 批量删除规格
     *
     * @param ids
     * @return
     */
    int deleteItemParams(long[] ids) throws DaoExcption;

    /**
     * 单独删除规格
     *
     * @param itemParamId
     * @return
     * @throws DaoExcption
     */
    int deleteItemParam(long itemParamId) throws DaoExcption;
}
