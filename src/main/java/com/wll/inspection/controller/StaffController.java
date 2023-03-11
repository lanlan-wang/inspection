package com.wll.inspection.controller;


import com.github.pagehelper.PageInfo;
import com.wll.inspection.VO.ResultVO;
import com.wll.inspection.dao.Company;
import com.wll.inspection.dao.Staff;
import com.wll.inspection.enums.ResultEnum;
import com.wll.inspection.form.LoginForm;
import com.wll.inspection.form.RegisterForm;
import com.wll.inspection.service.StaffService;
import com.wll.inspection.utils.ClientUtil;
import com.wll.inspection.utils.PageRequest;
import com.wll.inspection.utils.PageResult;
import com.wll.inspection.utils.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

/**
 * @author wll
 */
@Api(tags = "巡检人员")
@RequestMapping("/api/staff")
@Controller
@ResponseBody
@Slf4j
@CrossOrigin
public class StaffController {
    @Autowired
    StaffService staffService;

    @GetMapping("/delStaff/{staffId}")
    @ApiOperation("删除员工")
    public ResultVO delStaff(@PathVariable Long staffId){
        return staffService.deleteByPrimaryKey(staffId);
    }

    @GetMapping("/select/{staffId}")
    @ApiOperation("通过id查找")
    ResultVO selectById(@PathVariable Long staffId){
        return staffService.selectById(staffId);
    }

    @GetMapping("/selectAll")
    @ApiOperation("查找所有员工")
    ResultVO selectAll(){
        return staffService.selectAll();
    }

    @ApiOperation("分页查询")
    @GetMapping("/testPageHelper1/{pageNum}/{pageSize}")
    public PageInfo<Staff> testPageHelper1(@PathVariable int pageNum, @PathVariable int pageSize){
        PageInfo<Staff> queryResult = staffService.findAllUserByPageS(pageNum, pageSize);
        return queryResult;
    }

    @PostMapping("/login")
    @ApiOperation("登录")
    public ResultVO login(@RequestBody @Valid LoginForm loginForm , HttpServletResponse response, HttpServletRequest request) {
        return staffService.login(loginForm,response,request);
    }

    @PostMapping("/register")
    @ApiOperation("注册")
    public  ResultVO register(@RequestBody @Valid RegisterForm registerForm, HttpServletResponse response, HttpServletRequest request){
        return  staffService.register(registerForm,response,request);
    }

    @ApiOperation("发送验证码接口")
    @GetMapping(value = "/sendVerifyCode", name = "发送验证码接口")
    public ResultVO sendVerifyCode(HttpServletRequest request){
        String ip = ClientUtil.getClientIpAddress(request);
        String verifyCode;
        try {
            verifyCode = staffService.sendVerifyCode(ip);
        } catch (IOException e) {
            return ResultVOUtil.error(ResultEnum.IMAGE_CODE_OUT_DATE);
        }
        return ResultVOUtil.success(verifyCode);
    }

}
