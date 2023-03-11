package com.wll.inspection.form;

import com.wll.inspection.dao.Record;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author wll
 */
@Data
public class ImageUploadForm extends Record {

    @ApiModelProperty(value = "巡检记录ID")
    private Long recordId;

    @ApiModelProperty(value = "巡检照片")
    private String imagePath;

    public void setImagePath(String imagePath){
        this.imagePath = imagePath == null ? null : imagePath.trim();
    }

}
