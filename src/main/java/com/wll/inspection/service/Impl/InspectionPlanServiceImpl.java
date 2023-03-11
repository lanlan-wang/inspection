package com.wll.inspection.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wll.inspection.VO.ResultVO;
import com.wll.inspection.dao.Company;
import com.wll.inspection.dao.Equipment;
import com.wll.inspection.dao.InspectionPlan;
import com.wll.inspection.enums.ResultEnum;
import com.wll.inspection.mapper.InspectionPlanMapper;
import com.wll.inspection.service.InspectionPlanService;
import com.wll.inspection.utils.PageRequest;
import com.wll.inspection.utils.PageResult;
import com.wll.inspection.utils.PageUtils;
import com.wll.inspection.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class InspectionPlanServiceImpl implements InspectionPlanService {
    @Autowired
    InspectionPlanMapper inspectionPlanMapper ;

    @Override
    public ResultVO addInspectionPlan(InspectionPlan record) {
        if(inspectionPlanMapper.selectByPrimaryKey(record.getPlanId()) != null){
            return ResultVOUtil.error(ResultEnum.PLAN_HAS_EXIST);
        }
        return ResultVOUtil.success(inspectionPlanMapper.insert(record));
    }

    @Override
    public ResultVO deletePlan(Long Id) {
        if(inspectionPlanMapper.selectByPrimaryKey(Id) == null){
            return ResultVOUtil.error(ResultEnum.PLAN_NOT_EXIST);
        }else{
            inspectionPlanMapper.deleteByPrimaryKey(Id);
        }
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO selectAll() {
        return ResultVOUtil.success(inspectionPlanMapper.selectAll());
    }

    @Override
    public ResultVO updatePlan(InspectionPlan inspectionPlan) {
        if(inspectionPlanMapper.selectByPrimaryKey(inspectionPlan.getPlanId()) == null){
            return ResultVOUtil.error(ResultEnum.PLAN_NOT_EXIST);
        }
        return ResultVOUtil.success(inspectionPlanMapper.updateByPrimaryKey(inspectionPlan));
    }



    @Override
    public ResultVO selectById(Long Id) {
        if(inspectionPlanMapper.selectByPrimaryKey(Id) == null){
            return ResultVOUtil.error(ResultEnum.PLAN_NOT_EXIST);
        }
        return ResultVOUtil.success(inspectionPlanMapper.selectByPrimaryKey(Id));
    }

    @Override
    public PageInfo<InspectionPlan> findAllUserByPageS(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<InspectionPlan> lists = inspectionPlanMapper.pageSelect();
        PageInfo<InspectionPlan> pageInfo = new PageInfo<InspectionPlan>(lists);
        return pageInfo;
    }

}
