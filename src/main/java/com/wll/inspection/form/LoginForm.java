package com.wll.inspection.form;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author wll30
 */
@Data
public class LoginForm {

    @NotNull(message = "用户名不能为空")
    @ApiModelProperty("用户名")
    private String userName;

    @NotNull(message = "密码不能为空")
    @ApiModelProperty("密码")
    private String passWord;

//    @NotNull(message = "验证码不能为空")
//    @ApiModelProperty("图片验证码")
//    private String imageCode;
}
