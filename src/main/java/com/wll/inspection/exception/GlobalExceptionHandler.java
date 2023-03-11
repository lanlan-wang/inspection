package com.wll.inspection.exception;


import com.wll.inspection.VO.ResultVO;
import com.wll.inspection.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @Author: clf
 * @Date: 19-1-17
 * @Description:
 * 异常拦截器
 */
@ResponseBody
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    private final static String EXCEPTION_MSG_KEY = "Exception message : ";

    @ExceptionHandler(com.wll.inspection.exception.GlobalException.class)
    public ResultVO handleSelfException(com.wll.inspection.exception.GlobalException exception, HttpServletResponse response){
        log.error(EXCEPTION_MSG_KEY + exception.getMessage());
        return ResultVOUtil.error(exception);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO handleValidException(MethodArgumentNotValidException e){
        //日志记录错误信息
        log.error(Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
        //将错误信息返回给前台
        return ResultVOUtil.error(EXCEPTION_MSG_KEY, Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
    }

    @ExceptionHandler(NullPointerException.class)
    public ResultVO handleNullPonitException(NullPointerException e){
        //日志记录错误信息
        log.error(e.getMessage());
        //将错误信息返回给前台
        return ResultVOUtil.error(EXCEPTION_MSG_KEY, e.getMessage());
    }
}
