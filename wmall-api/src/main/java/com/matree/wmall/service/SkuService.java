package com.matree.wmall.service;

import com.matree.wmall.bean.PmsSkuInfo;

public interface SkuService {

    void saveSkuInfo(PmsSkuInfo pmsSkuInfo);

    PmsSkuInfo getItemById(String skuId);
}
