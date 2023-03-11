package com.wll.inspection.mapper;

import com.wll.inspection.dao.Company;
import com.wll.inspection.dao.InspectionTask;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InspectionTaskMapper {
    int deleteByPrimaryKey(Long taskId);

    int insert(InspectionTask record);

    InspectionTask selectByPrimaryKey(Long taskId);

    List<InspectionTask> selectAll();

    int updateByPrimaryKey(InspectionTask record);

    List<InspectionTask> pageSelect();
}