package com.wll.inspection.dao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Project对象", description="")
public class Project implements Serializable {

    @ApiModelProperty(value = "表格ID")
    private Long tableId;

    @ApiModelProperty(value = "设备检查项目ID")
    private Integer checkId;

    @ApiModelProperty(value = "设备ID")
    private Long equipmentId;

    @ApiModelProperty(value = "检查项目名")
    private String checkName;

    @ApiModelProperty(value = "RFID标签ID")
    private Long labelId;

}