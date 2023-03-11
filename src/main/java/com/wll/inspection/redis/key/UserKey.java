package com.wll.inspection.redis.key;

/**
 * @Author: clf
 * @Date: 19-1-18
 * @Description:
 */
public class UserKey extends BasePrefix{

    public UserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public UserKey(String prefix){
        super(prefix);
    }
    public static KeyPrefix getByUserId = new com.wll.inspection.redis.key.UserKey("userId");
    public static com.wll.inspection.redis.key.UserKey getUserByUserCode = new com.wll.inspection.redis.key.UserKey(300, "userCode");
    public static com.wll.inspection.redis.key.UserKey getByKeyWord = new com.wll.inspection.redis.key.UserKey(120, "keyWord");
    public static com.wll.inspection.redis.key.UserKey getLeaderByGroupId = new com.wll.inspection.redis.key.UserKey(300, "leaderOfGroup");
}
