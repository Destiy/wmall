package com.matree.wmall.item.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.matree.wmall.bean.PmsSkuInfo;
import com.matree.wmall.service.SkuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ItemController {

    @Reference
    SkuService skuService;

    @RequestMapping("/index")
    public String index(ModelMap modelMap){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("for data: " + i);
        }
        modelMap.put("list", list);
        modelMap.put("hello", "hello, thymeleaf!!");
        return "index";
    }

    @RequestMapping("/{skuId}.html")
    public String item(@PathVariable String skuId, ModelMap modelMap){
        PmsSkuInfo pmsSkuInfo = skuService.getItemById(skuId);

        modelMap.put("skuInfo", pmsSkuInfo);
        return "item";
    }
}
