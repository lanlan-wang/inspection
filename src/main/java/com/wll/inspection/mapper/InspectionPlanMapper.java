package com.wll.inspection.mapper;

import com.wll.inspection.dao.InspectionPlan;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InspectionPlanMapper {
    int deleteByPrimaryKey(Long planId);

    int insert(InspectionPlan record);

    InspectionPlan selectByPrimaryKey(Long planId);

    List<InspectionPlan> selectAll();

    int updateByPrimaryKey(InspectionPlan record);

    List<InspectionPlan> pageSelect();
}