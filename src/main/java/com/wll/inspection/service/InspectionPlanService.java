package com.wll.inspection.service;

import com.github.pagehelper.PageInfo;
import com.wll.inspection.VO.ResultVO;
import com.wll.inspection.dao.Company;
import com.wll.inspection.dao.InspectionPlan;
import com.wll.inspection.utils.PageRequest;
import com.wll.inspection.utils.PageResult;
import org.springframework.stereotype.Service;

@Service
public interface InspectionPlanService {
    ResultVO addInspectionPlan(InspectionPlan record);

    ResultVO deletePlan(Long Id);

    ResultVO selectAll();

    ResultVO updatePlan(InspectionPlan inspectionPlan);


    ResultVO selectById(Long Id);

    PageInfo<InspectionPlan> findAllUserByPageS(int pageNum, int pageSize);

}
