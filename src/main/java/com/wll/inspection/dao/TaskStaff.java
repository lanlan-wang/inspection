package com.wll.inspection.dao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TaskStaff对象", description="")
public class TaskStaff implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "指派ID")
    private Long appointId;

    @ApiModelProperty(value = "路线ID")
    private Long routeId;

    @ApiModelProperty(value = "任务ID")
    private Long taskId;

    @ApiModelProperty(value = "巡检人员ID")
    private Long staffId;

    @ApiModelProperty(value = "监督人员ID")
    private Long supervisorId;

    @ApiModelProperty(value = "巡检进度")
    private String process;

    @ApiModelProperty(value = "员工反馈信息")
    private String staffFeedback;

    @ApiModelProperty(value = "监督人员反馈信息")
    private String supervisorFeedback;



}