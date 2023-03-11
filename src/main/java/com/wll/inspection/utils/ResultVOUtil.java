package com.wll.inspection.utils;


import com.wll.inspection.VO.ResultVO;
import com.wll.inspection.enums.ResultEnum;
import com.wll.inspection.exception.GlobalException;

public class ResultVOUtil {
    /**
     * 无参结果成功
     * @return
     */
    public static ResultVO success(){
        return success(null);
    }

    /**
     * 有参结果返回
     * @param object
     * @return
     */
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;

    }

    public static ResultVO error(ResultEnum resultEnum){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(1);
        resultVO.setMsg(resultEnum.getMsg());
        return resultVO;
    }
    public static ResultVO error(GlobalException globalException) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(globalException.getCode());
        resultVO.setMsg(globalException.getMessage());
        return resultVO;
    }

    public static ResultVO error(String str, Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(1);
        resultVO.setMsg(str);
        resultVO.setData(object);
        return resultVO;

    }
}
