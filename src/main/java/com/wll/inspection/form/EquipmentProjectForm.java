package com.wll.inspection.form;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author wll
 */
@Data
public class EquipmentProjectForm {

    @ApiModelProperty(value = "设备检查项目ID")
    private Integer checkId;

    @ApiModelProperty(value = "检查项目名")
    private String checkName;


}
