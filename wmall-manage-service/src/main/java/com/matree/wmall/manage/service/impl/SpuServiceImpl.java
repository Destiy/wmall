package com.matree.wmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.matree.wmall.bean.PmsProductInfo;
import com.matree.wmall.manage.mapper.PmsProductInfoMppaer;
import com.matree.wmall.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    PmsProductInfoMppaer pmsProductInfoMppaer;

    @Override
    public List<PmsProductInfo> getSpuList(String catalog3Id) {
        PmsProductInfo pmsProductInfo = new PmsProductInfo();
        pmsProductInfo.setCatalog3Id(catalog3Id);
        return pmsProductInfoMppaer.select(pmsProductInfo);
    }
}
