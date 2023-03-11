package com.wll.inspection.service;


import com.github.pagehelper.PageInfo;
import com.wll.inspection.VO.ResultVO;
import com.wll.inspection.dao.InspectionTask;


public interface InspectionTaskService {
    ResultVO deleteByPrimaryKey(Long TaskId);

    ResultVO selectById(Long id);

    ResultVO addTask(InspectionTask record);

    ResultVO selectAll();

    PageInfo<InspectionTask> findAllUserByPageS(int pageNum, int pageSize);

    ResultVO update(InspectionTask inspectionTask);

    /**
     * 查找未完成任务
     * @param staffId
     * @return
     */
    ResultVO selectTaskNotFinish(Long staffId);

    /**
     * 查询结束任务（包括已完成和逾期任务）
     * @param staffId
     * @return
     */
    ResultVO selectTaskFinished(Long staffId);

}
