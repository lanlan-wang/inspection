package com.wll.inspection.dao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Equipment对象", description="")
public class Equipment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备ID")
    private Long equipmentId;

    @ApiModelProperty(value = "设备名称")
    private String equipmentName;

    @ApiModelProperty(value = "站场ID")
    private Long stationId;

    @ApiModelProperty(value = "RFID标签ID")
    private Long labelId;

    @ApiModelProperty(value = "设备类型")
    private String type;

    @ApiModelProperty(value = "设备信息")
    private String location;

    @ApiModelProperty(value = "设备位置信息")
    private String state;

    @ApiModelProperty(value = "设备运转状况")
    private String information;

}