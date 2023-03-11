package com.wll.inspection.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ImageUtil implements InitializingBean {

    //读取配置文件内容
    @Value("${aliyun-oss.endpoint}")
    private String endpoint;

    @Value("${aliyun-oss.accessKeyId}")
    private String accessKeyId;

    @Value("${aliyun-oss.accessKeySecret}")
    private String accessKeySecret;

    @Value("${aliyun-oss.bucketName}")
    private String bucketName;

    //定义公开静态常量
    public static String END_POINT;
    public static String ACCESS_KEY;
    public static String ACCESS_KEY_SECRET;
    public static String BUCKET_NAME;

    @Override
    public void afterPropertiesSet() throws Exception {
        END_POINT = endpoint;
        ACCESS_KEY = accessKeyId;
        ACCESS_KEY_SECRET = accessKeySecret;
        BUCKET_NAME = bucketName;
    }
}
