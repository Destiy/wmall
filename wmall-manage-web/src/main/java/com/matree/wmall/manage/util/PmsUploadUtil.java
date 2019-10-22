package com.matree.wmall.manage.util;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

public class PmsUploadUtil {


    public static String uploadImage(MultipartFile multipartFile) {

        String imgUrl = "http://192.168.58.130";

        // 上传服务器
        // 配置fdfs 全局链接地址
        String s = PmsUploadUtil.class.getResource("/tracker.conf").getPath();

        try {
            ClientGlobal.init(s);

            TrackerClient trackerClient = new TrackerClient();

            // 获得一个trackerServer 的实例
            TrackerServer trackerServer = trackerClient.getConnection();

            // 通过tracker 获得一个storage 链接客户端
            StorageClient storageClient = new StorageClient(trackerServer, null);

            byte[] bytes = multipartFile.getBytes();
            String originalFilename = multipartFile.getOriginalFilename();
            String substring = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            String[] jpgs = storageClient.upload_file(bytes, substring, null);

            for (String jpg : jpgs) {
                imgUrl += "/" + jpg;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return imgUrl;
    }
}
