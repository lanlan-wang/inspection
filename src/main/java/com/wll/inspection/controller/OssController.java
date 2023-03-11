package com.wll.inspection.controller;

import com.alibaba.fastjson.JSONObject;
import com.wll.inspection.VO.ResultVO;
import com.wll.inspection.service.OssService;
import com.wll.inspection.utils.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author wll
 */

@RestController
@RequestMapping("imageOss")
@Api(tags = "文件，照片上传")
@Controller
@CrossOrigin
public class OssController {
    @Autowired
    OssService ossService;

    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    public ResultVO uploadImage(@RequestParam(value = "file") MultipartFile file) throws RuntimeException {
        String url =  ossService.imageUpload(file);
        return ResultVOUtil.success(url);
    }


    @PostMapping("/video")
    @ApiOperation(value = "文件，视频上传，上限1GB")
    public ResultVO uploadVideo(@RequestParam(value = "file") MultipartFile file) throws RuntimeException{
        String url =  ossService.imageUpload(file);
        return ResultVOUtil.success(url);
    }
}
