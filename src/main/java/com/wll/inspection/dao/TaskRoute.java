package com.wll.inspection.dao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TaskRoute对象", description="")
public class TaskRoute implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "表格ID")
    private Long tableId;

    @ApiModelProperty(value = "巡检任务ID")
    private Long taskId;

    @ApiModelProperty(value = "巡检路线ID")
    private Long routeId;


}