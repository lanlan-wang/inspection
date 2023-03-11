package com.wll.inspection.utils;


import javax.servlet.http.HttpServletRequest;

/**
 * @author wll30
 * 客户端工具类
 */
public class ClientUtil {

    /**
     * 获取客户端请求的IP
     * @param request
     * @return
     */
    public static String getClientIpAddress(HttpServletRequest request){
        String clientIp = request.getHeader("x-forwarded-for");
        if(clientIp == null || clientIp.length() == 0 || "unknow".equalsIgnoreCase(clientIp)){
            clientIp = request.getHeader("Proxy-client-IP");
        }
        if(clientIp == null || clientIp.length() == 0 || "unknow".equalsIgnoreCase(clientIp)){
            clientIp = request.getHeader("WL-Proxy-Client-IP");
        }
        if(clientIp == null || clientIp.length() == 0 || "unknow".equalsIgnoreCase(clientIp)){
            clientIp = request.getRemoteAddr();
        }
        return clientIp;
    }
}
