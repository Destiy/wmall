package com.matree.wmall.service;

import com.matree.wmall.bean.PmsBaseAttrInfo;

import java.util.List;

/**
 * @author
 * @create 2019-09-05 1:07
 */
public interface AttrService {
    List<PmsBaseAttrInfo> getAttrInfoList(String catalog3Id);
}