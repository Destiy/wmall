package com.matree.wmall.manage.controller;

import com.matree.wmall.bean.PmsBaseAttrInfo;
import com.matree.wmall.service.AttrService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author
 * @create 2019-09-05 1:01
 */
@Controller
@CrossOrigin
public class AttrController {

    @Reference
    AttrService attrService;

    @ResponseBody
    @GetMapping("/attrInfoList")
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id){
        List<PmsBaseAttrInfo> attrInfos = attrService.getAttrInfoList(catalog3Id);
        return attrInfos;
    }
}


