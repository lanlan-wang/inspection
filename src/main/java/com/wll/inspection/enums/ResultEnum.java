package com.wll.inspection.enums;

public enum ResultEnum {
    COMPANY_HAS_EXIST(1,"公司已经存在"),
    COMPANY_HAS_NOT_EXIST(2,"公司不存在"),
    EQUIPMENT_HAS_EXIST(3,"设备已经存在"),
    EQUIPMENT_NOT_EXIST(4,"设备不存在"),
    PLAN_HAS_EXIST(5,"计划已经存在"),
    PLAN_NOT_EXIST(6,"计划不存在"),
    RECORD_NOT_EXIST(7,"记录不存在"),
    RECORD_HAS_EXIST(8,"记录存在"),
    PROJECT_HAS_EXIST(9,"设备项目存在"),
    PROJECT_NOT_EXIST(10,"设备项目不存在"),
    STATION_HAS_EXIST(11,"站场存在"),
    STATION_NOT_EXIST(12,"战场不存在"),
    STAFF_HAS_EXIST(13,"人员已存在"),
    STAFF_NOT_EXIST(14,"人员不存在"),
    ROUTE_NOT_EXIST(15,"路线不存在"),
    ROUTE_HAS_EXIST(16,"路线存在"),
    TASK_HAS_EXIST(17,"任务已经存在"),
    TASK_NOT_EXIST(18,"任务不存在"),
    IMAGE_CODE_OUT_DATE(19, "图片验证码过期或不存在"),
    SQL_ERROR(20, "添加用户失败"),
    AUTHENTICATION_ERROR(21,"权限认证失败"),
    PERMISSION_DENNY(22,"拒绝权限"),
    EQUIPMENT_PROJECT_NOT_EXIST(23,"设备对应项目不存在"),
    TASK_HAS_FINISH(24,"项目已经完成"),
    TASK_NOT_FINISH(25,"任务未完成"),
    TASK_HAS_APPOINTED(26,"任务已经指派，不能删除"),
    EQUIPMENT_IN_USE(27,"设备正在使用，不能删除"),
    ;
    private Integer code;
    private String msg;
    ResultEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }


    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
