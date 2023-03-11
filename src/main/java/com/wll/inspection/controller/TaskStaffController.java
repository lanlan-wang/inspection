package com.wll.inspection.controller;

import com.github.pagehelper.PageInfo;
import com.wll.inspection.dao.TaskRoute;
import com.wll.inspection.dao.TaskStaff;
import com.wll.inspection.service.TaskStaffService;
import com.wll.inspection.utils.PageRequest;
import com.wll.inspection.utils.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author wll
 */
@RestController
@RequestMapping("/task-staff")
@Api(tags = "任务-员工-控制器")
@Controller
@CrossOrigin
public class TaskStaffController {
    @Autowired
    TaskStaffService taskStaffService;

    @ApiOperation("分页查询")
    @GetMapping("/testPageHelper1/{pageNum}/{pageSize}")
    public PageInfo<TaskStaff> testPageHelper1(@PathVariable int pageNum, @PathVariable int pageSize){
        PageInfo<TaskStaff> queryResult = taskStaffService.findAllUserByPageS(pageNum, pageSize);
        return queryResult;
    }


}
