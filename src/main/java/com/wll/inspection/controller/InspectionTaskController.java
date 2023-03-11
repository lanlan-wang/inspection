package com.wll.inspection.controller;

import com.github.pagehelper.PageInfo;
import com.wll.inspection.VO.ResultVO;
import com.wll.inspection.dao.Company;
import com.wll.inspection.dao.InspectionTask;
import com.wll.inspection.service.InspectionTaskService;
import com.wll.inspection.utils.PageRequest;
import com.wll.inspection.utils.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author wll
 */
@Api(tags = "巡检任务")
@RequestMapping("/InspectionTask")
@Controller
@ResponseBody
@Slf4j
@CrossOrigin
public class InspectionTaskController {
    @Autowired
    private InspectionTaskService  inspectionTaskService;

    @GetMapping("/delTask/{taskId}")
    @ApiOperation("删除任务")
    public ResultVO delCompany(@PathVariable Long taskId) {

        return inspectionTaskService.deleteByPrimaryKey(taskId);
    }

    @PostMapping("/addTask/")
    @ApiOperation("添加任务")
    public ResultVO addCompany(@RequestBody InspectionTask record){
        return inspectionTaskService.addTask(record);
    }

    @GetMapping("/selectById/{Id}")
    @ApiOperation("通过Id查询任务")
    public ResultVO selectById(@PathVariable Long Id)
    {
        return inspectionTaskService.selectById(Id);
    }

    @GetMapping("/selectAll")
    @ApiOperation("查找所有的任务")
    public ResultVO selectAll(){
        return inspectionTaskService.selectAll();
    }

    @ApiOperation("分页查询")
    @GetMapping("/testPageHelper1/{pageNum}/{pageSize}")
    public PageInfo<InspectionTask> testPageHelper1(@PathVariable int pageNum, @PathVariable int pageSize){
        PageInfo<InspectionTask> queryResult = inspectionTaskService.findAllUserByPageS(pageNum, pageSize);
        return queryResult;
    }

    @ApiOperation("查询当前用户待完成任务")
    @GetMapping("/selectTaskNotFinish/{staffId}")
    public ResultVO selectTaskNotFinish(@PathVariable Long staffId){

        long hash = (staffId.hashCode() >>> 16) ^ staffId.hashCode();

        return inspectionTaskService.selectTaskNotFinish(staffId);
    }

    @GetMapping("/selectTaskFinished/{staffId}")
    @ApiOperation("查询结束任务，包括已完成和逾期任务")
    public ResultVO selectTaskFinished(@PathVariable Long staffId){
        return inspectionTaskService.selectTaskFinished(staffId);
    }


}
