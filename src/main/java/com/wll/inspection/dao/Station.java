package com.wll.inspection.dao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Station对象", description="")
public class Station implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "站场ID")
    private Long stationId;

    @ApiModelProperty(value = "站场位置")
    private String address;

    @ApiModelProperty(value = "站场所属公司ID")
    private Long companyId;

    @ApiModelProperty(value = "站场名字")
    private String name;

}