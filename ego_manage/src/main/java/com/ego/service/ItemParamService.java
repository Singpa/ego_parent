package com.ego.service;

import com.ego.commons.pojo.EasyUIDatagrid;
import com.ego.commons.pojo.EgoResult;

public interface ItemParamService {
    /**
     * 分页查询商品规格
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    EasyUIDatagrid selectItemParamPage(int pageNum, int pageSize);

    /**
     * 商品类型id查询商品参数
     *
     * @param itemCatId
     * @return
     */
    EgoResult selectItemParamByItemCatId(Long itemCatId);

    /**
     * 保存商品参数
     *
     * @param itemCatId
     * @param paramData
     * @return
     */
    EgoResult saveItemParam(Long itemCatId, String paramData);

    /**
     * 批量删除商品参数
     *
     * @param ids
     * @return
     */
    EgoResult deleteItemParam(long[] ids);
}
