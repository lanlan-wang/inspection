package com.wll.inspection.mapper;

import com.wll.inspection.dao.TaskRoute;
import com.wll.inspection.dao.TaskStaff;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wll
 */
@Repository
public interface TaskRouteMapper {
    int deleteByPrimaryKey(Long tableId);

    int insert(TaskRoute record);

    TaskRoute selectByPrimaryKey(Long tableId);

    List<TaskRoute> selectAll();

    int updateByPrimaryKey(TaskRoute record);
    /**
     * 分页查询
     * @return
     */
    List<TaskRoute> pageSelect();
}