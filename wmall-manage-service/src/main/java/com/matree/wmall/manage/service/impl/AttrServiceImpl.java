package com.matree.wmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.matree.wmall.bean.PmsBaseAttrInfo;
import com.matree.wmall.bean.PmsBaseAttrValue;
import com.matree.wmall.manage.mapper.PmsBaseAttrInfoMapper;
import com.matree.wmall.manage.mapper.PmsBaseAttrValueMapper;
import com.matree.wmall.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author
 * @create 2019-09-05 1:07
 */
@Service
public class AttrServiceImpl implements AttrService {

    @Autowired
    PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;

    @Autowired
    PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

    @Override
    public List<PmsBaseAttrInfo> getAttrInfoList(String catalog3Id) {
        PmsBaseAttrInfo pmsBaseAttrInfo = new PmsBaseAttrInfo();
        pmsBaseAttrInfo.setCatalog3Id(catalog3Id);
        return pmsBaseAttrInfoMapper.select(pmsBaseAttrInfo);
    }

    @Override
    public Integer saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
        int attrId = pmsBaseAttrInfoMapper.insertSelective(pmsBaseAttrInfo);
        return attrId;
    }

    @Override
    public void saveAttrValue(PmsBaseAttrInfo pmsBaseAttrInfo, Integer attrId) {
        List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
        for (PmsBaseAttrValue value : attrValueList) {
            value.setAttrId(String.valueOf(attrId));
            pmsBaseAttrValueMapper.insertSelective(value);
        }
    }
}
