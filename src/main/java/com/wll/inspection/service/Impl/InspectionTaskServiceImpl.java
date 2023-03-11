package com.wll.inspection.service.Impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wll.inspection.VO.ResultVO;
import com.wll.inspection.dao.InspectionTask;
import com.wll.inspection.dao.TaskStaff;
import com.wll.inspection.enums.ResultEnum;
import com.wll.inspection.form.TaskFinishedForm;
import com.wll.inspection.form.TaskNotFinishForm;
import com.wll.inspection.mapper.InspectionTaskMapper;
import com.wll.inspection.mapper.StaffMapper;
import com.wll.inspection.mapper.TaskStaffMapper;
import com.wll.inspection.service.InspectionTaskService;
import com.wll.inspection.utils.PageRequest;
import com.wll.inspection.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author wll
 */
@Service
@Slf4j
public class InspectionTaskServiceImpl implements InspectionTaskService {
    @Autowired
    InspectionTaskMapper inspectionTaskMapper;

    @Autowired
    TaskStaffMapper taskStaffMapper;

    @Autowired
    StaffMapper staffMapper;

    private static final String NotFinish = "0";

    private static final String Finish = "1";

    @Override
    public ResultVO deleteByPrimaryKey(Long TaskId) {
        if(inspectionTaskMapper.selectByPrimaryKey(TaskId) == null){
            return ResultVOUtil.error(ResultEnum.TASK_NOT_EXIST);
        }else if(taskStaffMapper.selectTaskByTaskId(TaskId) != null){
            return ResultVOUtil.error(ResultEnum.TASK_HAS_APPOINTED);
        }
        return ResultVOUtil.success(inspectionTaskMapper.deleteByPrimaryKey(TaskId));
    }

    @Override
    public ResultVO selectById(Long id) {
        if(inspectionTaskMapper.selectByPrimaryKey(id) == null){
            return ResultVOUtil.error(ResultEnum.TASK_NOT_EXIST);
        }
        return ResultVOUtil.success(inspectionTaskMapper.selectByPrimaryKey(id));
    }

    @Override
    public ResultVO addTask(InspectionTask record) {
        if(inspectionTaskMapper.selectByPrimaryKey(record.getTaskId()) != null){
            return ResultVOUtil.error(ResultEnum.TASK_HAS_EXIST);
        }
        inspectionTaskMapper.insert(record);
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO selectAll() {
        return ResultVOUtil.success(inspectionTaskMapper.selectAll());
    }

    @Override
    public PageInfo<InspectionTask> findAllUserByPageS(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<InspectionTask> lists = inspectionTaskMapper.pageSelect();
        PageInfo<InspectionTask> pageInfo = new PageInfo<InspectionTask>(lists);
        return pageInfo;
    }


    @Override
    public ResultVO update(InspectionTask inspectionTask) {
        try{
            return ResultVOUtil.success(inspectionTaskMapper.updateByPrimaryKey(inspectionTask));
        }catch(Exception e){
            return ResultVOUtil.error(ResultEnum.TASK_NOT_EXIST);
        }
    }


    @Override
    public ResultVO selectTaskNotFinish(Long staffId) {
        TaskNotFinishForm taskNotFinishForm = new TaskNotFinishForm();
        if(taskStaffMapper.selectTaskByStaffId(staffId) == null){
            return ResultVOUtil.error(ResultEnum.TASK_NOT_EXIST);
        }
        TaskStaff taskStaff = taskStaffMapper.selectTaskByStaffId(staffId);
        InspectionTask inspectionTask = inspectionTaskMapper.selectByPrimaryKey(taskStaff.getTaskId());
        Date now = new Date();

        log.info("现在时间"+now);
        log.info("-----------------------------------------------------------");
        if(inspectionTask.getEndTime().after(now)){
            return ResultVOUtil.error(ResultEnum.TASK_HAS_FINISH);
        }
        taskNotFinishForm.setTaskId(inspectionTask.getTaskId());
        taskNotFinishForm.setPublishId(taskStaff.getStaffId());
        taskNotFinishForm.setPublishName((staffMapper.selectByPrimaryKey(staffId)).getName());
        taskNotFinishForm.setStartTime(inspectionTask.getStartTime());
        taskNotFinishForm.setAttachment(inspectionTask.getAttachment());
        taskNotFinishForm.setContent(inspectionTask.getContent());
        return ResultVOUtil.success(taskNotFinishForm);
    }

    @Override
    public ResultVO selectTaskFinished(Long staffId) {
        TaskFinishedForm taskFinishedForm = new TaskFinishedForm();
        if(taskStaffMapper.selectTaskByStaffId(staffId) == null){
            return ResultVOUtil.error(ResultEnum.TASK_NOT_EXIST);
        }
        TaskStaff taskStaff = taskStaffMapper.selectTaskByStaffId(staffId);
        InspectionTask inspectionTask = inspectionTaskMapper.selectByPrimaryKey(taskStaff.getTaskId());
        Date now = new Date();

        log.info("现在时间"+now);
        log.info("-----------------------------------------------------------");
        if(inspectionTask.getEndTime().before(now)){
            return ResultVOUtil.error(ResultEnum.TASK_NOT_FINISH);
        }else {
            if (taskStaff.getProcess() == NotFinish) {
                taskFinishedForm.setStatus("逾期");
            }else if(taskStaff.getProcess() == Finish){
                taskFinishedForm.setStatus("已完成");
            }
        }

        taskFinishedForm.setTaskId(inspectionTask.getTaskId());
        taskFinishedForm.setPublishId(taskStaff.getStaffId());
        taskFinishedForm.setPublishName((staffMapper.selectByPrimaryKey(staffId)).getName());
        taskFinishedForm.setStartTime(inspectionTask.getStartTime());
        taskFinishedForm.setAttachment(inspectionTask.getAttachment());
        taskFinishedForm.setContent(inspectionTask.getContent());
        return ResultVOUtil.success(taskFinishedForm);
    }

}
