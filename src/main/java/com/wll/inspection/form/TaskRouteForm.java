package com.wll.inspection.form;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author wll
 */
@Data
public class TaskRouteForm {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "指派ID")
    private Long appointId;

    @ApiModelProperty(value = "路线ID")
    private Long routeId;

    @ApiModelProperty(value = "任务ID")
    private Long taskId;

    @ApiModelProperty(value = "巡检进度")
    private String process;
}
