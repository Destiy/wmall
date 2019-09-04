package com.matree.wmall.service;

import com.matree.wmall.bean.PmsBaseCatalog1;
import com.matree.wmall.bean.PmsBaseCatalog2;
import com.matree.wmall.bean.PmsBaseCatalog3;

import java.util.List;

/**
 * @author
 * @create 2019-08-29 0:44
 */
public interface CatalogService {

    /**
     * 查询一级分类
     *
     * @return
     */
    List<PmsBaseCatalog1> getCatalog1();

    /**
     * 查询二级分类
     *
     * @param catalog1Id    一级分类id
     * @return
     */
    List<PmsBaseCatalog2> getCatalog2(Integer catalog1Id);

    /**
     *  查询三级分类
     *
     * @param catalog2Id    三级分类id
     * @return
     */
    List<PmsBaseCatalog3> getCatalog3(Integer catalog2Id);
}
