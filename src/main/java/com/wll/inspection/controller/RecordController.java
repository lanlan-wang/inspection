package com.wll.inspection.controller;

import com.github.pagehelper.PageInfo;
import com.wll.inspection.VO.ResultVO;
import com.wll.inspection.dao.Company;
import com.wll.inspection.dao.Record;
import com.wll.inspection.service.RecordService;
import com.wll.inspection.utils.PageRequest;
import com.wll.inspection.utils.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author wll
 */
@Api(tags = "巡检记录")
@RequestMapping("/Record")
@Controller
@ResponseBody
@Slf4j
@CrossOrigin
public class RecordController {
    @Autowired
    RecordService recordService;
    @GetMapping("/deleteRecord/{Id}")
    @ApiOperation("删除记录")
    public ResultVO deleteRecord(@PathVariable Long Id){
        return recordService.deleteRecord(Id) ;
    }

    @PostMapping("/addRecord")
    @ApiOperation("添加记录")
    public ResultVO addRecord(@RequestBody Record  record){
        return recordService.addRecord(record) ;
    }

    @PostMapping("/updateRecord")
    @ApiOperation("更新记录")
    public ResultVO updateRecord(@RequestBody  Record  record ){
        return recordService.updateRecord(record) ;
    }

    @ApiOperation("分页查询")
    @GetMapping("/testPageHelper1/{pageNum}/{pageSize}")
    public PageInfo<Record> testPageHelper1(@PathVariable int pageNum, @PathVariable int pageSize){
        PageInfo<Record> queryResult = recordService.findAllUserByPageS(pageNum, pageSize);
        return queryResult;
    }

    @GetMapping("/selectAll")
    @ApiOperation("查看所有记录")
    public ResultVO selectAll(){
        return recordService.selectAll();
    }

    @GetMapping("/selectById/{Id}")
    @ApiOperation("通过id查询")
    public ResultVO selectById(@PathVariable Long Id){
        return recordService.selectById(Id);
    }
}
