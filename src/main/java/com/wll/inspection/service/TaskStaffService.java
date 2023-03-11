package com.wll.inspection.service;

import com.github.pagehelper.PageInfo;
import com.wll.inspection.dao.Company;
import com.wll.inspection.dao.TaskStaff;
import com.wll.inspection.utils.PageRequest;
import com.wll.inspection.utils.PageResult;

/**
 * @author wll
 */
public interface TaskStaffService {
    PageInfo<TaskStaff> findAllUserByPageS(int pageNum, int pageSize);
}
