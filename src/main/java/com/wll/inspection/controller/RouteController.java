package com.wll.inspection.controller;


import com.github.pagehelper.PageInfo;
import com.wll.inspection.VO.ResultVO;
import com.wll.inspection.dao.Company;
import com.wll.inspection.dao.Route;
import com.wll.inspection.service.CompanyService;
import com.wll.inspection.service.RouteService;
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

@Api(tags = "巡检路线")
@RequestMapping("/route")
@Controller
@ResponseBody
@Slf4j
@CrossOrigin
public class RouteController {
    @Autowired
    private RouteService routeService;

    @GetMapping("/delRoute/{RouteId}")
    @ApiOperation("删除路线")
    public ResultVO delRoute(@PathVariable Long RouteId) {
        return routeService.deleteByPrimaryKey(RouteId);
    }

    @PostMapping("/addRoute")
    @ApiOperation("添加路线")
    public ResultVO addRoute(@RequestBody Route route){
        return routeService.addRoute(route);
    }

    @GetMapping("/selectById/{Id}")
    @ApiOperation("通过Id查询路线")
    public ResultVO selectById(@PathVariable Long Id)
    {
        return routeService.selectById(Id);
    }

    @GetMapping("/selectAll")
    @ApiOperation("查找所有的路线")
    public ResultVO selectAll(){
        return routeService.selectAll();
    }

    @ApiOperation("分页查询")
    @GetMapping("/testPageHelper1/{pageNum}/{pageSize}")
    public PageInfo<Route> testPageHelper1(@PathVariable int pageNum, @PathVariable int pageSize){
        PageInfo<Route> queryResult = routeService.findAllUserByPageS(pageNum, pageSize);
        return queryResult;
    }


}
