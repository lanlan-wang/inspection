package com.wll.inspection.dao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


@Data
@EqualsAndHashCode(callSuper = false)//自动的给实体的bean实现equals方法和hashcode方法
@ApiModel(value="Company对象", description="")//swagger注解，标记类时swagger的解析类
public class Company implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "公司ID")
    private Long companyId;

    @ApiModelProperty(value = "公司名称")
    private String name;

    @ApiModelProperty(value = "公司地址")
    private String address;

}