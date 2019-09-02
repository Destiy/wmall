package com.matree.wmall.manage;

import com.alibaba.dubbo.config.annotation.Reference;
import com.matree.wmall.service.CatalogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WmallManageServiceApplicationTests {

    @Reference
    CatalogService catalogService;

    @Test
    public void contextLoads() {
        System.out.println(catalogService.getCatalog1());
    }

}
