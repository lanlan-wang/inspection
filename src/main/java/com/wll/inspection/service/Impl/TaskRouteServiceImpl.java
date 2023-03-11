package com.wll.inspection.service.Impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wll.inspection.VO.ResultVO;
import com.wll.inspection.controller.TaskRouteController;
import com.wll.inspection.dao.Station;
import com.wll.inspection.dao.TaskRoute;
import com.wll.inspection.dao.TaskStaff;
import com.wll.inspection.enums.ResultEnum;
import com.wll.inspection.form.TaskRouteForm;
import com.wll.inspection.mapper.InspectionTaskMapper;
import com.wll.inspection.mapper.TaskRouteMapper;
import com.wll.inspection.mapper.TaskStaffMapper;
import com.wll.inspection.service.TaskRouteService;
import com.wll.inspection.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TaskRouteServiceImpl implements TaskRouteService {
    @Autowired
    TaskRouteMapper taskRouteMapper;
    @Autowired
    TaskStaffMapper taskStaffMapper;
    @Autowired
    InspectionTaskMapper inspectionTaskMapper;


    @Override
    public PageInfo<TaskRoute> findAllUserByPageS(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TaskRoute> lists = taskRouteMapper.pageSelect();
        PageInfo<TaskRoute> pageInfo = new PageInfo<TaskRoute>(lists);
        return pageInfo;
    }

    @Override
    public ResultVO selectRouteByTask(Long staffId, Long taskId) {
        TaskRouteForm taskRouteForm =  new TaskRouteForm();
        if(inspectionTaskMapper.selectByPrimaryKey(taskId) == null){
            return ResultVOUtil.error(ResultEnum.TASK_NOT_EXIST);
        }
        TaskStaff taskStaff = taskStaffMapper.selectTaskByTaskId(taskId);

        taskRouteForm.setAppointId(taskStaff.getAppointId());
        taskRouteForm.setRouteId(taskStaff.getRouteId());
        taskRouteForm.setTaskId(taskStaff.getTaskId());
        taskRouteForm.setProcess(taskStaff.getProcess());

        return ResultVOUtil.success(taskRouteForm);
    }
}
