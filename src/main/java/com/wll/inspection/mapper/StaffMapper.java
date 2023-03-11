package com.wll.inspection.mapper;

import com.wll.inspection.dao.Staff;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffMapper {
    int deleteByPrimaryKey(Long staffId);

    Staff selectByPrimaryKey(Long id);

    List<Staff> pageSelect();

    List<Staff> selectAll();

    Staff getByName(String name);

    int updateByPrimaryKey(Staff staff);

    int   insert(Staff staff);
}