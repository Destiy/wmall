package com.matree.wmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.matree.wmall.bean.PmsProductInfo;
import com.matree.wmall.service.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
public class SpuController {


    @Reference
    SpuService spuService;

    @ResponseBody
    @GetMapping("/spuList")
    public List<PmsProductInfo> spuList(String catalog3Id){
        List<PmsProductInfo> pmsProductInfoList = spuService.getSpuList(catalog3Id);
        return pmsProductInfoList;
    }

    @RequestMapping("/saveSpuInfo")
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo){

        return "success";
    }
}
