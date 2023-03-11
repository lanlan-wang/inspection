package com.wll.inspection.dao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="InspectionTask对象", description="")
public class InspectionTask implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "巡检任务ID")
    private Long taskId;

    @ApiModelProperty(value = "巡检任务名")
    private String taskName;

    @ApiModelProperty(value = "任务所属计划ID")
    private Long planId;

    @ApiModelProperty(value = "任务开始时间")
    private Date startTime;

    @ApiModelProperty(value = "任务结束时间")
    private Date endTime;

    @ApiModelProperty(value = "任务内容")
    private String content;

    @ApiModelProperty(value = "备注信息")
    private String attachment;

}