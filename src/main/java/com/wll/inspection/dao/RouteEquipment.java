package com.wll.inspection.dao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="RouteEquipment对象", description="")
public class RouteEquipment implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "表格ID")
    private Long tableId;

    @ApiModelProperty(value = "路线ID")
    private Long routeId;

    @ApiModelProperty(value = "巡检顺序ID")
    private Long sequenseId;

    @ApiModelProperty(value = "设备ID")
    private Long equipmentId;

}