package com.wll.inspection.utils;


import java.util.UUID;

/**
 * 生成文件名
 * @author wll
 */
public class UUIDUtils {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
