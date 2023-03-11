package com.wll.inspection.controller;

import com.github.pagehelper.PageInfo;
import com.wll.inspection.VO.ResultVO;
import com.wll.inspection.dao.Company;
import com.wll.inspection.dao.TaskRoute;
import com.wll.inspection.service.RouteEquipmentService;
import com.wll.inspection.service.TaskRouteService;
import com.wll.inspection.service.TaskStaffService;
import com.wll.inspection.utils.PageRequest;
import com.wll.inspection.utils.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wll
 */

@RestController
@RequestMapping("/task-route")
@Api(tags = "任务-路线-控制器")
@Controller
@CrossOrigin
public class TaskRouteController {


    @Autowired
    private RouteEquipmentService routeEquipmentService;

    @Autowired
    private TaskRouteService taskRouteService;

    @ApiOperation("分页查询")
    @GetMapping("/testPageHelper1/{pageNum}/{pageSize}")
    public PageInfo<TaskRoute> testPageHelper1(@PathVariable int pageNum, @PathVariable int pageSize){
        PageInfo<TaskRoute> queryResult = taskRouteService.findAllUserByPageS(pageNum, pageSize);
        return queryResult;
    }

    @GetMapping("selectByRouteId/{routeId}")
    @ApiOperation(value = "查询指派路线下的设备")
    public List selectEquipmentInRoute(@PathVariable Long routeId){
        return routeEquipmentService.selectEquipmentInRoute(routeId);
    }


    @GetMapping("selectRouteByTaskId/{staffId}/{taskId}")
    @ApiOperation(value = "查询对应任务下的路线")
    public ResultVO selectRouteByTaskId(@PathVariable Long staffId,@PathVariable Long taskId){
        return taskRouteService.selectRouteByTask(staffId,taskId);
    }





}
