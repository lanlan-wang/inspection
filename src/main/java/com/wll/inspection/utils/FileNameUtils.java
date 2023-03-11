package com.wll.inspection.utils;


/**
 * @author wll
 */
public class FileNameUtils {

    /**
     * 获取文件后缀
     * @param fileName
     * @return
     */
    public static String getSuffix(String fileName){
        return fileName.substring(fileName.lastIndexOf("."));
    }

    public static String getFileName(String fileOriginName){
        return UUIDUtils.getUUID() + FileNameUtils.getSuffix(fileOriginName);
    }

}
