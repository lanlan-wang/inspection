package com.wll.inspection.controller;


import com.github.pagehelper.PageInfo;
import com.wll.inspection.dao.Company;
import com.wll.inspection.dao.RouteEquipment;
import com.wll.inspection.service.RouteEquipmentService;
import com.wll.inspection.utils.PageRequest;
import com.wll.inspection.utils.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wll
 */

@RestController
@RequestMapping("route-equipment")
@Api(tags = "路线-设备-控制器")
@ResponseBody
@CrossOrigin
@Slf4j
public class RouteEquipmentController {
    @Autowired
    private RouteEquipmentService routeEquipmentService;

    @ApiOperation("分页查询")
    @GetMapping("/testPageHelper1/{pageNum}/{pageSize}")
    public PageInfo<RouteEquipment> testPageHelper1(@PathVariable int pageNum, @PathVariable int pageSize){
        PageInfo<RouteEquipment> queryResult = routeEquipmentService.findAllUserByPageS(pageNum, pageSize);
        return queryResult;
    }


}
