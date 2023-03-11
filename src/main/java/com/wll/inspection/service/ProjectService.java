package com.wll.inspection.service;

import com.github.pagehelper.PageInfo;
import com.wll.inspection.VO.ResultVO;
import com.wll.inspection.dao.Company;
import com.wll.inspection.dao.Project;
import com.wll.inspection.utils.PageRequest;
import com.wll.inspection.utils.PageResult;

public interface ProjectService {

    ResultVO deleteProject(Long Id);

    ResultVO selectById(Long id);

    ResultVO addProject(Project record);

    ResultVO selectAll();

    PageInfo<Project> findAllUserByPageS(int pageNum, int pageSize);

    ResultVO update(Project  project);

    /**
     * 查询设备id对应下的检查项目
     * @param equipmentId
     * @return
     */
    ResultVO selectProjectByEquipmentId(Long equipmentId);
}
