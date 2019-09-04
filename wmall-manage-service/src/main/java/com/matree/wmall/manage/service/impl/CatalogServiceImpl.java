package com.matree.wmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.matree.wmall.bean.PmsBaseCatalog1;
import com.matree.wmall.bean.PmsBaseCatalog2;
import com.matree.wmall.bean.PmsBaseCatalog3;
import com.matree.wmall.manage.mapper.PmsBasecatalog1Mapper;
import com.matree.wmall.manage.mapper.PmsBasecatalog2Mapper;
import com.matree.wmall.manage.mapper.PmsBasecatalog3Mapper;
import com.matree.wmall.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author
 * @create 2019-08-29 0:49
 */

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired(required = false)
    private PmsBasecatalog1Mapper pmsBasecatalog1Mapper;

    @Autowired(required = false)
    private PmsBasecatalog2Mapper pmsBasecatalog2Mapper;

    @Autowired(required = false)
    private PmsBasecatalog3Mapper pmsBasecatalog3Mapper;

    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        return pmsBasecatalog1Mapper.selectAll();
    }

    @Override
    public List<PmsBaseCatalog2> getCatalog2(Integer catalog1Id) {
        PmsBaseCatalog2 pmsBaseCatalog2 = new PmsBaseCatalog2();
        pmsBaseCatalog2.setCatalog1Id(String.valueOf(catalog1Id));
        return pmsBasecatalog2Mapper.select(pmsBaseCatalog2);
    }

    @Override
    public List<PmsBaseCatalog3> getCatalog3(Integer catalog2Id) {
        PmsBaseCatalog3 pmsBaseCatalog3 = new PmsBaseCatalog3();
        pmsBaseCatalog3.setCatalog2Id(String.valueOf(catalog2Id));
        return pmsBasecatalog3Mapper.select(pmsBaseCatalog3);
    }

}
