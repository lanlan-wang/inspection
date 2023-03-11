package com.wll.inspection.service.Impl;


import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.wll.inspection.service.OssService;
import com.wll.inspection.utils.ImageUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wll
 */
@Service
public class OssServiceImpl implements OssService {
    @Override
    public String imageUpload(MultipartFile file) {


        // yourEndpoint填写Bucket所在地域对应的Endpoint。以华东1（杭州）为例，Endpoint填写为https://oss-cn-hangzhou.aliyuncs.com。
        //String endpoint = "yourEndpoint";
        String endpoint = ImageUtil.END_POINT;
        //String accessKeyId = "yourAccessKeyId";
        String accessKeyId = ImageUtil.ACCESS_KEY;
        //String accessKeySecret = "yourAccessKeySecret";
        String accessKeySecret = ImageUtil.ACCESS_KEY_SECRET;
        //String bucketName = "";
        String bucketName = ImageUtil.BUCKET_NAME;

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {

            InputStream inputStream = file.getInputStream();

            // 填写Bucket名称和Object完整路径，Object完整路径中不能包含Bucket名称
            ossClient.putObject(bucketName, file.getOriginalFilename(), inputStream);

            //关闭OSSClient
            ossClient.shutdown();

            //拼接url
            String url = "https://" + bucketName + "." + endpoint + "/" +file.getOriginalFilename();

            return url;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return null;
        }
    }
}
