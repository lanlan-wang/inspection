package com.wll.inspection.service;


import org.springframework.web.multipart.MultipartFile;

/**
 * @author wll
 */
public interface OssService {

    /**
     * 上传图片
     * @param file
     * @return
     */
    String imageUpload(MultipartFile file);

}
