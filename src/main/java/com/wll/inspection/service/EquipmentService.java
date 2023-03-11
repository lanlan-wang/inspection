package com.wll.inspection.service;

import com.github.pagehelper.PageInfo;
import com.wll.inspection.VO.ResultVO;
import com.wll.inspection.dao.Company;
import com.wll.inspection.dao.Equipment;
import com.wll.inspection.utils.PageRequest;
import com.wll.inspection.utils.PageResult;
import org.springframework.stereotype.Service;

/**
 * @author wll
 */
@Service
public interface EquipmentService {

    /**
     * 添加设备
     * @param equipment
     * @return
     */
    ResultVO addEquipment(Equipment equipment);

    /**
     * 删除设备
     * @param Id
     * @return
     */
    ResultVO deleteEquipment(Long Id);

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Equipment> findAllUserByPageS(int pageNum, int pageSize);

    /**
     * 查找所有的设备
     * @return
     */
    ResultVO selectAll();

    /**
     * 更新设备
     * @param equipment
     * @return
     */
    ResultVO update(Equipment equipment);

    /**
     * 通过id查找设备
     * @param Id
     * @return
     */
    ResultVO selectById(Long Id);


}
