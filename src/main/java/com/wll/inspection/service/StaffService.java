package com.wll.inspection.service;

import com.github.pagehelper.PageInfo;
import com.wll.inspection.VO.ResultVO;
import com.wll.inspection.dao.Company;
import com.wll.inspection.dao.Staff;
import com.wll.inspection.form.LoginForm;
import com.wll.inspection.form.RegisterForm;
import com.wll.inspection.utils.PageRequest;
import com.wll.inspection.utils.PageResult;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wll30
 */
@Service
public interface StaffService {

    /**
     *通过id删除
     * @param StaffId
     * @return
     */
    ResultVO deleteByPrimaryKey(Long StaffId);

    /**
     * 通过id查找员工
     * @param id
     * @return
     */
    ResultVO selectById(Long id);

    /**
     * 查找所有的员工
     * @return
     */
    ResultVO selectAll();

    PageInfo<Staff> findAllUserByPageS(int pageNum, int pageSize);

    /**
     * 注册
     * @param registerForm
     * @param response
     * @param request
     * @return
     */
    ResultVO register(RegisterForm registerForm , HttpServletResponse response , HttpServletRequest request );

    /**
     * 更新员工信息
     * @param staff
     * @return
     */
    ResultVO update(Staff staff);

    /**
     * 校验验证码时正确
     * @param userSendCode
     * @param equalCode
     * @return
     */
    Boolean checkVerifyCode(String userSendCode,String equalCode);

    /**
     * 发送验证码
     * @param clientIp
     * @return
     * @throws IOException
     */
    String sendVerifyCode(String clientIp) throws IOException;

    /**
     * 登录
     * @param loginForm
     * @param response
     * @param request
     * @return
     */
    ResultVO login(LoginForm loginForm,HttpServletResponse response, HttpServletRequest request);

    /**
     * 获取当前用户
     * @return
     */
    Staff getCurrentUser();

    /**
     * 根据用户名查找当前用户
     * @param username
     * @return
     */
    Staff getUserByUsername(String username);

}
