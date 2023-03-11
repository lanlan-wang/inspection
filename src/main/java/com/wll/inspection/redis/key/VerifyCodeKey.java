package com.wll.inspection.redis.key;

/**
 * @Author: clf
 * @Date: 19-1-17
 * @Description:
 * 验证码的key封装
 */
public class VerifyCodeKey extends BasePrefix {

    public VerifyCodeKey(String prefix) {
        super(prefix);
    }

    public VerifyCodeKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static com.wll.inspection.redis.key.VerifyCodeKey getByClientIp = new com.wll.inspection.redis.key.VerifyCodeKey(240,"clientIp");
}
