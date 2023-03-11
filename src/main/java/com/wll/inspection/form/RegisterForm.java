package com.wll.inspection.form;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author wll
 */
@Data
public class RegisterForm {

    @NotNull
    @ApiModelProperty("用户ID")
    private Long staffId;

    @NotNull
    @ApiModelProperty("用户名")
    private String name;

    @NotNull
    @Size(min = 6,max = 12)
    @ApiModelProperty("密码最短为6位，最长为12位")
    private String password;

    @NotNull
    @ApiModelProperty("电话号码")
    private String phone;

    @NotNull
    @ApiModelProperty("员工权限")
    private Integer privilege;

    @NotNull
    @ApiModelProperty(value = "员工所属站场ID")
    private Long stationId;

//    @ApiModelProperty("验证码")
//    @NotNull
//    private String verifyCode;

}
