package com.wll.inspection.mapper;

import com.wll.inspection.dao.Equipment;
import com.wll.inspection.utils.PageRequest;
import com.wll.inspection.utils.PageResult;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wll
 */
@Repository
public interface EquipmentMapper {
    int deleteByPrimaryKey(Long equipmentId);

    int insert(Equipment record);

    Equipment selectByPrimaryKey(Long equipmentId);

    List<Equipment> selectAll();

    int updateByPrimaryKey(Equipment record);

    List<Equipment> pageSelect();
}