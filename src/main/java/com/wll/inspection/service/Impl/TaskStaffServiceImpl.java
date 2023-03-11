package com.wll.inspection.service.Impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wll.inspection.dao.Company;
import com.wll.inspection.dao.TaskStaff;
import com.wll.inspection.mapper.TaskStaffMapper;
import com.wll.inspection.service.TaskStaffService;
import com.wll.inspection.utils.PageRequest;
import com.wll.inspection.utils.PageResult;
import com.wll.inspection.utils.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wll
 */
@Service
@Slf4j
public class TaskStaffServiceImpl  implements TaskStaffService {
    @Autowired
    TaskStaffMapper taskStaffMapper;


    @Override
    public PageInfo<TaskStaff> findAllUserByPageS(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TaskStaff> lists = taskStaffMapper.pageSelect();
        PageInfo<TaskStaff> pageInfo = new PageInfo<TaskStaff>(lists);
        return pageInfo;
    }
}
