package com.matree.wmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.matree.wmall.bean.PmsBaseCatalog1;
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

}
