package com.matree.wmall.manage;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WmallManageWebApplicationTests {

    @Test
    public void contextLoads() throws IOException, MyException {

        // 配置fdfs 全局链接地址
        String s = WmallManageWebApplicationTests.class.getResource("/tracker.conf").getPath();

        ClientGlobal.init(s);

        TrackerClient trackerClient = new TrackerClient();

        // 获得一个trackerServer 的实例
        TrackerServer trackerServer = trackerClient.getConnection();

        // 通过tracker 获得一个storage 链接客户端
        StorageClient storageClient = new StorageClient(trackerServer, null);

        String[] jpgs = storageClient.upload_file("C:\\Users\\Administrator\\Desktop\\feaa8c7162086f5170938be3234f942.jpg", "jpg", null);

        String url = "http://192.168.58.130";
        for (String jpg : jpgs) {
            url += "/" + jpg;
        }

        System.out.println("----------------------------------------------");
        System.out.println(url);
    }

}
