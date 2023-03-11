package com.wll.inspection.security;

import com.alibaba.fastjson.JSON;
import com.wll.inspection.dao.Staff;
import com.wll.inspection.mapper.StaffMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author GO FOR IT
 * @ClassName JwtUserDetailServiceImpl
 * @Date 19-4-22 下午7:24
 * @Description UserDetailService实现类
 **/

@Service
@Slf4j
public class JwtUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private StaffMapper staffMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("userName：" + JSON.toJSONString(username));
        Staff staff = staffMapper.getByName(username);
        log.info("staff信息：" + JSON.toJSONString(staff));
        if (staff == null) {
            log.info("此用户不存在");
            throw new UsernameNotFoundException(String.format("用户名为 %s 的用户不存在", username));
        } else {
            Integer role = Integer.valueOf(staff.getPrivilege());
            return new JwtUser(username, staff.getPassword(), role);
        }
    }
}
