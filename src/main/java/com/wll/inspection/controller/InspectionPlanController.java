package com.wll.inspection.controller;


import com.github.pagehelper.PageInfo;
import com.wll.inspection.VO.ResultVO;
import com.wll.inspection.dao.Company;
import com.wll.inspection.dao.InspectionPlan;
import com.wll.inspection.service.InspectionPlanService;
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
@Api(tags = "巡检计划")
@RequestMapping("/InspectionPlan")
@Controller
@ResponseBody
@Slf4j
@CrossOrigin
public class InspectionPlanController {
    @Autowired
    InspectionPlanService inspectionPlanService;

    @GetMapping("/deletePlan/{Id}")
    @ApiOperation("删除计划")
    public ResultVO deletePlan(@PathVariable Long Id){
        return inspectionPlanService.deletePlan(Id);
    }

    @PostMapping("/addPlan")
    @ApiOperation("添加计划")
    public ResultVO addPlan(@RequestBody InspectionPlan record){
        return inspectionPlanService.addInspectionPlan(record);
    }

    @PostMapping("/updatePlan")
    @ApiOperation("更新计划")
    public ResultVO updatePlan(@RequestBody  InspectionPlan inspectionPlan){
        return inspectionPlanService.updatePlan(inspectionPlan);
    }

    @ApiOperation("分页查询")
    @GetMapping("/testPageHelper1/{pageNum}/{pageSize}")
    public PageInfo<InspectionPlan> testPageHelper1(@PathVariable int pageNum, @PathVariable int pageSize){
        PageInfo<InspectionPlan> queryResult = inspectionPlanService.findAllUserByPageS(pageNum, pageSize);
        return queryResult;
    }

    @GetMapping("/selectAll")
    @ApiOperation("查看所有计划")
    public ResultVO selectAll(){
        return inspectionPlanService.selectAll();
    }

    @GetMapping("/selectById/{Id}")
    @ApiOperation("通过id查询")
    public ResultVO selectById(@PathVariable Long Id){
        return inspectionPlanService.selectById(Id);
    }
}
