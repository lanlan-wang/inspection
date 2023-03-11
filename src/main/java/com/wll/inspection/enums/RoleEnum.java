package com.wll.inspection.enums;

import lombok.Getter;

import java.util.HashMap;

/**
 * @author GO FOR IT
 */

@Getter
public enum RoleEnum {

    /**
     *用户角色
     */
    USER(0, "巡检人员"),
    ADMIN(3,"总管理员");


    private Integer value;
    private String role;

    RoleEnum(Integer value, String role) {
        this.value = value;
        this.role = role;
    }

    public static String getRole(Integer integer) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(ADMIN.getValue(), ADMIN.getRole());
        hashMap.put(USER.getValue(), USER.getRole());
        return hashMap.get(integer);
    }

    public static Integer getValue(String role) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put(ADMIN.role, ADMIN.getValue());
        hashMap.put(USER.role, USER.getValue());
        return hashMap.get(role);
    }
}
