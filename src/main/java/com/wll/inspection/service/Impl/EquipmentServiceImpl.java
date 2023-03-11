package com.wll.inspection.service.Impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wll.inspection.VO.ResultVO;
import com.wll.inspection.dao.Company;
import com.wll.inspection.dao.Equipment;
import com.wll.inspection.enums.ResultEnum;
import com.wll.inspection.mapper.CompanyMapper;
import com.wll.inspection.mapper.EquipmentMapper;
import com.wll.inspection.mapper.RouteEquipmentMapper;
import com.wll.inspection.service.CompanyService;
import com.wll.inspection.service.EquipmentService;
import com.wll.inspection.utils.PageRequest;
import com.wll.inspection.utils.PageResult;
import com.wll.inspection.utils.PageUtils;
import com.wll.inspection.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EquipmentServiceImpl implements EquipmentService {
    @Autowired
    EquipmentMapper equipmentMapper ;

    @Autowired
    RouteEquipmentMapper routeEquipmentMapper;

    @Override
    public ResultVO addEquipment(Equipment equipment) {
        try{
            if(equipmentMapper.selectByPrimaryKey(equipment.getEquipmentId()) == null)
            {
                equipmentMapper.insert(equipment);
            }
        }catch (Exception e){
            return ResultVOUtil.error(ResultEnum.EQUIPMENT_HAS_EXIST);
        }
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO deleteEquipment(Long Id) {
        if(equipmentMapper.selectByPrimaryKey(Id) == null){
            return ResultVOUtil.error(ResultEnum.EQUIPMENT_NOT_EXIST);
        }else if(routeEquipmentMapper.selectByEquipmentId(Id) != null){
            return ResultVOUtil.error(ResultEnum.EQUIPMENT_IN_USE);
        } else{
            equipmentMapper.deleteByPrimaryKey(Id);
        }
        return ResultVOUtil.success();
    }

    @Override
    public PageInfo<Equipment> findAllUserByPageS(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Equipment> lists = equipmentMapper.pageSelect();
        PageInfo<Equipment> pageInfo = new PageInfo<Equipment>(lists);
        return pageInfo;
    }


    @Override
    public ResultVO selectAll() {
        return ResultVOUtil.success(equipmentMapper.selectAll());
    }

    @Override
    public ResultVO update(Equipment equipment) {
        try{
            if(equipmentMapper.selectByPrimaryKey(equipment.getEquipmentId()) != null){
                equipmentMapper.updateByPrimaryKey(equipment);
            }
            return ResultVOUtil.success();
        }catch(Exception e){
            return ResultVOUtil.error(ResultEnum.EQUIPMENT_NOT_EXIST);
        }

    }

    @Override
    public ResultVO selectById(Long Id) {
        try{
            return ResultVOUtil.success(equipmentMapper.selectByPrimaryKey(Id));
        }catch(Exception e){
            return ResultVOUtil.error(ResultEnum.EQUIPMENT_NOT_EXIST);
        }
    }

    private PageInfo<Equipment> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Equipment> equipments = equipmentMapper.pageSelect();
        return new PageInfo<Equipment>(equipments);
    }
}
