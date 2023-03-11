package com.wll.inspection.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wll.inspection.DTO.VerifyCode;
import com.wll.inspection.VO.ResultVO;
import com.wll.inspection.dao.Company;
import com.wll.inspection.dao.Staff;
import com.wll.inspection.enums.ResultEnum;
import com.wll.inspection.exception.GlobalException;
import com.wll.inspection.form.LoginForm;
import com.wll.inspection.form.RegisterForm;
import com.wll.inspection.mapper.StaffMapper;
import com.wll.inspection.redis.RedisService;
import com.wll.inspection.redis.key.VerifyCodeKey;
import com.wll.inspection.security.JwtProperties;
import com.wll.inspection.security.JwtUserDetailServiceImpl;
import com.wll.inspection.service.StaffService;
import com.wll.inspection.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

@Service
@Slf4j
public class StaffServiceImpl implements StaffService {
    @Autowired
    private  StaffMapper staffMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RedisService redisService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtProperties jwtProperties;
    @Autowired
    private JwtUserDetailServiceImpl jwtUserDetailService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public ResultVO deleteByPrimaryKey(Long StaffId) {
        try{
            return ResultVOUtil.success(staffMapper.deleteByPrimaryKey(StaffId));
        }catch(Exception e){
            return ResultVOUtil.error(ResultEnum.STAFF_NOT_EXIST);
        }
    }

    @Override
    public ResultVO selectById(Long id) {
        return ResultVOUtil.success(staffMapper.selectByPrimaryKey(id));
    }


    @Override
    public ResultVO selectAll() {
        return ResultVOUtil.success(staffMapper.selectAll());
    }

    @Override
    public PageInfo<Staff> findAllUserByPageS(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Staff> lists = staffMapper.pageSelect();
        PageInfo<Staff> pageInfo = new PageInfo<Staff>(lists);
        return pageInfo;
    }


    @Override
    public ResultVO register(RegisterForm registerForm, HttpServletResponse response, HttpServletRequest request) {
//        String code = registerForm.getVerifyCode().toLowerCase(Locale.ROOT);
//        String clientIpAddress = ClientUtil.getClientIpAddress(request);
////        log.info("IP={},VerifyCode={}",clientIpAddress,code);
//        String relCode = redisService.get(VerifyCodeKey.getByClientIp,clientIpAddress,String.class);
//        redisService.delete(VerifyCodeKey.getByClientIp,clientIpAddress);
        if(staffMapper.getByName(registerForm.getName()) != null){
            throw new GlobalException(ResultEnum.STAFF_HAS_EXIST);
        }

//        if(!checkVerifyCode(code,relCode)){
//            log.error("【图片验证码错误】,userDetail={}",registerForm.getUserName());
//            throw new GlobalException(ResultEnum.IMAGE_CODE_OUT_DATE);
//        }
        Staff staff = new Staff();
        BeanUtils.copyProperties(registerForm,staff);
        staff.setPassword(passwordEncoder.encode(staff.getPassword()));
        int result = staffMapper.insert(staff);
        if(1 != result){
            throw new GlobalException(ResultEnum.SQL_ERROR);
        }
        log.info("【注册成功】，user={}",staff);
        return ResultVOUtil.success();

    }

    @Override
    public ResultVO update(Staff staff) {
        try{
            if(staffMapper.selectByPrimaryKey(staff.getStaffId()) !=null)
            {
                staffMapper.updateByPrimaryKey(staff);
            }
        }catch(Exception e){
            return ResultVOUtil.error(ResultEnum.STAFF_NOT_EXIST);
        }
        return ResultVOUtil.success();
    }

    @Override
    public Boolean checkVerifyCode(String userSendCode, String equalCode) {
        if(userSendCode == null || !userSendCode.equals(equalCode)){
            return false;
        }
        return true;
    }


    @Override
    public String sendVerifyCode(String clientIp) throws IOException {
        VerifyCode code = new VerifyCode();
        BufferedImage image = code.getImage();
        String text = code.getText();
        StringBuilder randomCode = new StringBuilder();
        randomCode.append(text);
        redisService.set(VerifyCodeKey.getByClientIp, clientIp,text.toLowerCase());
        log.info("redis-signCode =====> {}",randomCode.toString());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image,"jpg",baos);
        byte[] bytes = baos.toByteArray();
        BASE64Encoder encoder = new BASE64Encoder();
        String jpg_base64 = encoder.encode(bytes).trim();
        jpg_base64 = jpg_base64.replaceAll("\n","").replaceAll("\r","");
        return jpg_base64;
    }

    @Override
    public ResultVO login(LoginForm loginForm, HttpServletResponse response, HttpServletRequest request) {

        log.info("loginForm:" + loginForm);
        @NotNull(message = "密码不为空") //String code = loginForm.getImageCode().toLowerCase(Locale.ROOT);
//        String clientIpAddress = ClientUtil.getClientIpAddress(request);
        //log.info("IP={},VerifyCode={}",clientIpAddress,code);
//        String relCode = redisService.get(VerifyCodeKey.getByClientIp,clientIpAddress,String.class);
//        redisService.delete(VerifyCodeKey.getByClientIp,clientIpAddress);

        //if(!checkVerifyCode(code,relCode)){
           // log.error("【图片验证码错误】，userDetail={}",loginForm.getUserName());
            //throw new GlobalException(ResultEnum.IMAGE_CODE_OUT_DATE);
        //}

        Staff staff = staffMapper.getByName(loginForm.getUserName());
        log.info("登录信息：userDetail={}",staff);

        UserDetails userDetails = jwtUserDetailService.loadUserByUsername(loginForm.getUserName());
        //Authentication token = new UsernamePasswordAuthenticationToken(loginForm.getUserName(),loginForm.getPassWord(),userDetails.getAuthorities());
        //Authentication authentication = authenticationManager.authenticate(token);
        //SecurityContextHolder.getContext().setAuthentication(authentication);
        //final String realToken = jwtTokenUtil.generateToken(userDetails);

       // response.addHeader(jwtProperties.getTokenName(),realToken);
        Map<String, Serializable> map = new HashMap<>(7);
//        map.put("Id",staff.getStaffId());
        map.put("name",staff.getName());
        map.put("role",staff.getPrivilege());
        //map.put("token",realToken);
        log.info("【登录成功】，userDetail={}",userDetails);
        return ResultVOUtil.success(map);
    }

    @Override
    public Staff getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        String key = "anonymousUser";
        if(!userName.equals(key)){
            return getUserByUsername(userName);
        }
        return null;
    }




    @Override
    public Staff getUserByUsername(String username) {
        return staffMapper.getByName(username);
    }
}
