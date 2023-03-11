package com.wll.inspection.dao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author wll30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Staff对象", description="")
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "员工ID")
    private Long staffId;

    @ApiModelProperty(value = "员工姓名")
    private String name;

    @ApiModelProperty(value = "登录密码")
    private String password;

    @ApiModelProperty(value = "员工手机号")
    private String phone;

    @ApiModelProperty(value = "员工权限")
    private Integer privilege;

    @ApiModelProperty(value = "员工所属站场ID")
    private Long stationId;

    @ApiModelProperty(value = "员工头像")
    private String photo;
}