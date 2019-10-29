package com.matree.wmall.service;

import com.matree.wmall.bean.PmsProductImage;
import com.matree.wmall.bean.PmsProductInfo;
import com.matree.wmall.bean.PmsProductSaleAttr;

import java.util.List;

public interface SpuService {
    List<PmsProductInfo> getSpuList(String catalog3Id);

    String saveSpuInfo(PmsProductInfo pmsProductInfo);

    List<PmsProductSaleAttr> spuSaleAttrList(String spuId);

    List<PmsProductImage> getSpuImageList(String spuId);
}
