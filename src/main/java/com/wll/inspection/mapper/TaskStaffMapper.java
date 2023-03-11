package com.wll.inspection.mapper;

import com.wll.inspection.dao.Company;
import com.wll.inspection.dao.TaskStaff;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface  TaskStaffMapper {
    int deleteByPrimaryKey(@Param("appointId") Long appointId, @Param("routeId") Long routeId, @Param("taskId") Long taskId);

    int insert(TaskStaff record);

    TaskStaff selectByPrimaryKey(@Param("appointId") Long appointId, @Param("routeId") Long routeId, @Param("taskId") Long taskId);

    List<TaskStaff> selectAll();

    int updateByPrimaryKey(TaskStaff record);

    TaskStaff selectTaskByTaskId(Long taskId);

    TaskStaff selectTaskByStaffId(Long staffId);


    /**
     * 分页查询
     * @return
     */
    List<TaskStaff> pageSelect();
}