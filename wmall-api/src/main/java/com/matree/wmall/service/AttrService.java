package com.matree.wmall.service;

import com.matree.wmall.bean.PmsBaseAttrInfo;
import com.matree.wmall.bean.PmsBaseAttrValue;

import java.util.List;

/**
 * @author
 * @create 2019-09-05 1:07
 */
public interface AttrService {
    List<PmsBaseAttrInfo> getAttrInfoList(String catalog3Id);

    String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    List<PmsBaseAttrValue> getAttrValueList(String attrId);

//    void saveAttrValue(PmsBaseAttrInfo pmsBaseAttrInfo, Integer attrId);
}
