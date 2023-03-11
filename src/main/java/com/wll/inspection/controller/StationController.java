package com.wll.inspection.controller;

import com.github.pagehelper.PageInfo;
import com.wll.inspection.VO.ResultVO;
import com.wll.inspection.dao.Company;
import com.wll.inspection.dao.Station;
import com.wll.inspection.service.CompanyService;
import com.wll.inspection.service.StationService;
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
@Api(tags = "巡检站点")
@RequestMapping("/station")
@Controller
@ResponseBody
@Slf4j
@CrossOrigin
public class StationController {
    @Autowired
    private StationService stationService;

    @GetMapping("/delStation/{stationId}")
    @ApiOperation("删除站点")
    public ResultVO delStation(@PathVariable Long stationId) {
        return stationService.deleteStation(stationId);
    }

    @PostMapping("/addCompany")
    @ApiOperation("添加站点")
    public ResultVO addStation(@RequestBody Station record){
        return stationService.addStation(record);
    }

    @GetMapping("/selectById/{Id}")
    @ApiOperation("通过Id查询站点")
    public ResultVO selectById(@PathVariable Long Id)
    {
        return stationService.selectById(Id);
    }

    @GetMapping("/selectAll")
    @ApiOperation("查找所有的站点")
    public ResultVO selectAll(){
        return stationService.selectAll();
    }

    @ApiOperation("分页查询")
    @GetMapping("/testPageHelper1/{pageNum}/{pageSize}")
    public PageInfo<Station> testPageHelper1(@PathVariable int pageNum, @PathVariable int pageSize){
        PageInfo<Station> queryResult = stationService.findAllUserByPageS(pageNum, pageSize);
        return queryResult;
    }
}
