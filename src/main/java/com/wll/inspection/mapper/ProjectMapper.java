package com.wll.inspection.mapper;

import com.wll.inspection.dao.Project;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectMapper {
    int deleteByPrimaryKey(Long tableId);

    int insert(Project record);

    Project selectByPrimaryKey(Long tableId);

    List<Project> selectAll();

    int updateByPrimaryKey(Project record);

    List<Project> pageSelect();

    Project selectByEquipmentId(Long equipmentId);
}