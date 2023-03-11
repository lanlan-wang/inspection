package com.wll.inspection.security;

import com.alibaba.fastjson.JSON;
import com.wll.inspection.accessctro.RoleControl;
import com.wll.inspection.dao.Staff;
import com.wll.inspection.enums.ResultEnum;
import com.wll.inspection.service.StaffService;
import com.wll.inspection.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName AuthRoleInterceptor
 * @Author zty
 * @Date 19-4-22 下午7:47
 * @Description 权限验证
 **/
@Slf4j
@Service
public class AuthRoleInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private StaffService staffService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(".....................");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String json = JSON.toJSONString(ResultVOUtil.error(ResultEnum.AUTHENTICATION_ERROR));
        Staff staff = staffService.getCurrentUser();
        if ( staff == null) {
            return true;
        }
        log.info("============执行权限验证============");
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            RoleControl roleControl = handlerMethod.getMethodAnnotation(RoleControl.class);
            if (roleControl == null) {
                return true;
            }
            Integer roleValue = roleControl.role().getValue();
            Integer userValue = Integer.valueOf(staff.getPrivilege());
            log.info("RoleValue:{},userRole:{}", roleValue, userValue);
            if (userValue.equals(roleValue)) {
                return true;
            } else {
                json = JSON.toJSONString(ResultVOUtil.error(ResultEnum.PERMISSION_DENNY));
                log.info("============权限不足===============");
            }
        }
        response.getWriter().append(json);
        return false;
    }
}
