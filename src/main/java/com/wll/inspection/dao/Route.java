package com.wll.inspection.dao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Route对象", description="")
public class Route implements Serializable {

    @ApiModelProperty(value = "路线ID")
    private Long routeId;

    @ApiModelProperty(value = "路线名称")
    private String routeName;

    @ApiModelProperty(value = "路线所属站场")
    private Long stationId;

    @ApiModelProperty(value = "路线类型")
    private String type;

    @ApiModelProperty(value = "路线制定者ID")
    private Long makerId;

    @ApiModelProperty(value = "路线制定时间")
    private Date date;

    private static final long serialVersionUID = 1L;

}