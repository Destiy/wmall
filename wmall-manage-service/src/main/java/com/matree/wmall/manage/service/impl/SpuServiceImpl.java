package com.matree.wmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.matree.wmall.bean.PmsProductImage;
import com.matree.wmall.bean.PmsProductInfo;
import com.matree.wmall.bean.PmsProductSaleAttr;
import com.matree.wmall.bean.PmsProductSaleAttrValue;
import com.matree.wmall.manage.mapper.PmsProductImageMapper;
import com.matree.wmall.manage.mapper.PmsProductInfoMppaer;
import com.matree.wmall.manage.mapper.PmsProductSaleAttrMapper;
import com.matree.wmall.manage.mapper.PmsProductSaleAttrValueMapper;
import com.matree.wmall.service.SpuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    PmsProductInfoMppaer pmsProductInfoMppaer;

    @Autowired
    PmsProductImageMapper pmsProductImageMapper;

    @Autowired
    PmsProductSaleAttrMapper pmsProductSaleAttrMapper;

    @Autowired
    PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;

    @Override
    public List<PmsProductInfo> getSpuList(String catalog3Id) {
        PmsProductInfo pmsProductInfo = new PmsProductInfo();
        pmsProductInfo.setCatalog3Id(catalog3Id);
        return pmsProductInfoMppaer.select(pmsProductInfo);
    }

    @Override
    public String saveSpuInfo(PmsProductInfo pmsProductInfo) {

        String id = pmsProductInfo.getId();
        if (StringUtils.isBlank(id)){
            // 保存pms_info
            pmsProductInfoMppaer.insertSelective(pmsProductInfo);

            // 保存pms_image
            List<PmsProductImage> pmsProductImageList = pmsProductInfo.getPmsProductImageList();
            for (PmsProductImage pmsProductImage : pmsProductImageList) {
                pmsProductImage.setProductId(pmsProductInfo.getId());
                pmsProductImageMapper.insertSelective(pmsProductImage);
            }

            // 保存pms_attr
            List<PmsProductSaleAttr> pmsProductSaleAttrList = pmsProductInfo.getPmsProductSaleAttrList();
            for (PmsProductSaleAttr pmsProductSaleAttr : pmsProductSaleAttrList) {
                pmsProductSaleAttr.setProductId(pmsProductInfo.getId());
                pmsProductSaleAttrMapper.insertSelective(pmsProductSaleAttr);

                // 保存pms_attr_value
                List<PmsProductSaleAttrValue> pmsProductSaleAttrValueList = pmsProductSaleAttr.getPmsProductSaleAttrValueList();
                for (PmsProductSaleAttrValue pmsProductSaleAttrValue : pmsProductSaleAttrValueList) {
                    pmsProductSaleAttrValue.setProductId(pmsProductInfo.getId());
                    pmsProductSaleAttrValue.setSaleAttrId(pmsProductSaleAttr.getId());
                    pmsProductSaleAttrValueMapper.insertSelective(pmsProductSaleAttrValue);
                }
            }
        } else {

        }
        return "success";
    }
}
