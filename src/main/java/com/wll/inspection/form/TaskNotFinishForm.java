package com.wll.inspection.form;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author wll
 */
@Data
public class TaskNotFinishForm {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "巡检任务ID")
    private Long taskId;

    @ApiModelProperty(value = "发布人Id")
    private Long publishId;

    @ApiModelProperty(value = "发布人姓名")
    private String publishName;

    @ApiModelProperty(value = "任务开始时间")
    private Date startTime;

    @ApiModelProperty(value = "任务结束时间")
    private Date endTime;

    @ApiModelProperty(value = "任务内容")
    private String content;

    @ApiModelProperty(value = "备注信息")
    private String attachment;


}
