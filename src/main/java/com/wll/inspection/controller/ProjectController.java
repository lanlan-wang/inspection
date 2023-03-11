package com.wll.inspection.controller;

import com.github.pagehelper.PageInfo;
import com.wll.inspection.VO.ResultVO;
import com.wll.inspection.dao.Company;
import com.wll.inspection.dao.Project;
import com.wll.inspection.service.ProjectService;
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
@Api(tags = "巡检设备项目")
@RequestMapping("/Project")
@Controller
@ResponseBody
@Slf4j
@CrossOrigin
public class ProjectController {
    @Autowired
    ProjectService  projectService;
    @GetMapping("/deleteRecord/{Id}")
    @ApiOperation("删除设备项目")
    public ResultVO deleteProject(@PathVariable Long Id){
        return projectService.deleteProject(Id) ;
    }

    @PostMapping("/addRecord")
    @ApiOperation("添加设备项目")
    public ResultVO addProject(@RequestBody Project record){
        return projectService.addProject(record) ;
    }

    @PostMapping("/updateRecord")
    @ApiOperation("更新设备项目")
    public ResultVO updateProject(@RequestBody  Project  record ){
        return projectService.update(record) ;
    }

    @ApiOperation("分页查询")
    @GetMapping("/testPageHelper1/{pageNum}/{pageSize}")
    public PageInfo<Project> testPageHelper1(@PathVariable int pageNum, @PathVariable int pageSize){
        PageInfo<Project> queryResult = projectService.findAllUserByPageS(pageNum, pageSize);
        return queryResult;
    }

    @GetMapping("/selectAll")
    @ApiOperation("查看所有设备项目")
    public ResultVO selectAll(){
        return projectService.selectAll();
    }

    @GetMapping("/selectById/{Id}")
    @ApiOperation("通过id查询")
    public ResultVO selectById(@PathVariable Long Id){
        return projectService.selectById(Id);
    }

    @GetMapping("/selectByEquipmentId/{equipmentId}")
    @ApiOperation("查询设备id对应的检查项目")
    public ResultVO selectByEquipmentId(@PathVariable Long equipmentId){
        return projectService.selectProjectByEquipmentId(equipmentId);
    }

}
