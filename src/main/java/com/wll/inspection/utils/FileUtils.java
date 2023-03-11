package com.wll.inspection.utils;

import java.io.File;
import java.io.FileOutputStream;

/**
 * 文件上传工具包
 * @author wll
 */
public class FileUtils {
    /**
     *
     * @param file 文件
     * @param filePath 文件存放路径
     * @param fileName 源文件名
     * @throws Exception
     */
    public static void upload(byte[] file,String filePath,String fileName) throws Exception{
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }

        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}
