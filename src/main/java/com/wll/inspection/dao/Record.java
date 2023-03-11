package com.wll.inspection.dao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Record对象", description="")
public class Record implements Serializable {

    @ApiModelProperty(value = "巡检记录ID")
    private Long recordId;

    @ApiModelProperty(value = "指派ID")
    private Long appointId;

    @ApiModelProperty(value = "设备ID")
    private Long equipmentId;

    @ApiModelProperty(value = "巡检项目ID")
    private Long projectId;

    @ApiModelProperty(value = "巡检时间")
    private Date date;

    @ApiModelProperty(value = "巡检照片")
    private String photo;

    @ApiModelProperty(value = "巡检视频")
    private String video;

    @ApiModelProperty(value = "检查结果")
    private String record;

    private static final long serialVersionUID = 1L;

}