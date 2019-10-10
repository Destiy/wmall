package com.matree.wmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.matree.wmall.bean.PmsBaseAttrInfo;
import com.matree.wmall.bean.PmsBaseAttrValue;
import com.matree.wmall.service.AttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping("/saveAttrInfo")
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo){
        String result = attrService.saveAttrInfo(pmsBaseAttrInfo);
//        attrService.saveAttrValue(pmsBaseAttrInfo, attrId);
        return "success";
    }

    @ResponseBody
    @GetMapping("/attrInfoList")
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id){
        List<PmsBaseAttrInfo> attrInfos = attrService.getAttrInfoList(catalog3Id);
        return attrInfos;
    }

    @ResponseBody
    @PostMapping("/getAttrValueList")
    public List<PmsBaseAttrValue> getAttrValueList(String attrId){
        List<PmsBaseAttrValue> pmsBaseAttrValueList = attrService.getAttrValueList(attrId);
        return pmsBaseAttrValueList;
    }
}


