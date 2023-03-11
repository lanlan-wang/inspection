package com.wll.inspection.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wll.inspection.VO.ResultVO;
import com.wll.inspection.dao.Company;
import com.wll.inspection.dao.Equipment;
import com.wll.inspection.dao.Project;
import com.wll.inspection.enums.ResultEnum;
import com.wll.inspection.form.EquipmentProjectForm;
import com.wll.inspection.mapper.EquipmentMapper;
import com.wll.inspection.mapper.ProjectMapper;
import com.wll.inspection.service.ProjectService;
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
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectMapper projectMapper;

    @Override
    public ResultVO addProject(Project  project) {
        try{
            if(projectMapper.selectByPrimaryKey(project.getTableId()) == null)
            {
                projectMapper.insert(project);
            }
        }catch (Exception e){
            return ResultVOUtil.error(ResultEnum.PROJECT_HAS_EXIST);
        }
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO deleteProject(Long Id) {
        if(projectMapper.selectByPrimaryKey(Id) == null){
            return ResultVOUtil.error(ResultEnum.PROJECT_NOT_EXIST);
        }
        return ResultVOUtil.success(projectMapper.deleteByPrimaryKey(Id));
    }

    @Override
    public ResultVO selectById(Long id) {
        if(projectMapper.selectByPrimaryKey(id) == null){
            return ResultVOUtil.error(ResultEnum.PROJECT_NOT_EXIST);
        }
        return ResultVOUtil.success(projectMapper.selectByPrimaryKey(id));
    }


    @Override
    public ResultVO selectAll() {
        return ResultVOUtil.success(projectMapper.selectAll());
    }

    @Override
    public PageInfo<Project> findAllUserByPageS(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Project> lists = projectMapper.pageSelect();
        PageInfo<Project> pageInfo = new PageInfo<Project>(lists);
        return pageInfo;
    }

    @Override
    public ResultVO update(Project project) {
        try{
            if(projectMapper.selectByPrimaryKey(project.getEquipmentId()) != null){
                projectMapper.updateByPrimaryKey(project);
            }
        }catch(Exception e){
            return ResultVOUtil.error(ResultEnum.PROJECT_NOT_EXIST);
        }
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO selectProjectByEquipmentId(Long equipmentId) {
        EquipmentProjectForm equipmentProjectForm = new EquipmentProjectForm();
        if(projectMapper.selectByEquipmentId(equipmentId) == null){
            return ResultVOUtil.error(ResultEnum.EQUIPMENT_PROJECT_NOT_EXIST);
        }

        Project project = projectMapper.selectByEquipmentId(equipmentId);

        equipmentProjectForm.setCheckId(project.getCheckId());
        equipmentProjectForm.setCheckName(project.getCheckName());
        return ResultVOUtil.success(equipmentProjectForm);
    }


    private PageInfo<Project> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Project> projects = projectMapper.pageSelect();
        return new PageInfo<Project>(projects);
    }

}
