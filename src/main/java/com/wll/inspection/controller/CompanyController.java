package com.wll.inspection.controller;

import com.github.pagehelper.PageInfo;
import com.wll.inspection.VO.ResultVO;
import com.wll.inspection.dao.Company;
import com.wll.inspection.service.CompanyService;
import com.wll.inspection.utils.PageRequest;
import com.wll.inspection.utils.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wll
 */
@Api(tags = "巡检公司")
@RequestMapping("/company")
@Controller
@ResponseBody
@Slf4j
@CrossOrigin
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/delCompany/{CompanyId}")
    @ApiOperation("删除公司")
    public ResultVO delCompany(@PathVariable Long CompanyId) {
        return companyService.deleteByPrimaryKey(CompanyId);
    }

    @PostMapping("/addCompany")
    @ApiOperation("添加公司")
    public ResultVO addCompany(@RequestBody Company record){
        return companyService.addCompany(record);
    }

    @GetMapping("/selectById/{Id}")
    @ApiOperation("通过Id查询公司")
    public ResultVO selectById(@PathVariable Long Id)
    {
        return companyService.selectById(Id);
    }

    @GetMapping("/selectAll")
    @ApiOperation("查找所有的公司")
    public ResultVO selectAll(){
        return companyService.selectAll();
    }

    @ApiOperation("分页查询")
    @GetMapping("/testPageHelper1/{pageNum}/{pageSize}")
    public PageInfo<Company> testPageHelper1(@PathVariable int pageNum,@PathVariable int pageSize){
        PageInfo<Company> queryResult = companyService.findAllUserByPageS(pageNum, pageSize);
        return queryResult;
    }


}