package com.wll.inspection.service;


import com.github.pagehelper.PageInfo;
import com.wll.inspection.VO.ResultVO;
import com.wll.inspection.dao.Station;
import com.wll.inspection.dao.TaskRoute;
import org.springframework.stereotype.Service;

/**
 * @author wll
 */
@Service
public interface TaskRouteService {

    PageInfo<TaskRoute> findAllUserByPageS(int pageNum, int pageSize);

    /**
     * 查询对应任务下的路线
     * @param staffId
     * @param taskId
     * @return
     */
    ResultVO selectRouteByTask(Long staffId,Long taskId);

}
