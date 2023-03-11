package com.wll.inspection.dao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="InspectPlan对象", description="")
public class InspectionPlan implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "巡检计划ID")
    private Long planId;

    @ApiModelProperty(value = "巡检名称")
    private String planName;

    @ApiModelProperty(value = "计划下发方式")
    private Integer issuedWay;

    @ApiModelProperty(value = "计划开始时间")
    private Date startDate;

    @ApiModelProperty(value = "计划结束时间")
    private Date endDate;

    @ApiModelProperty(value = "计划执行次数")
    private Integer frequency;

}