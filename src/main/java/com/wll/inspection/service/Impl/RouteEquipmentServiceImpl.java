package com.wll.inspection.service.Impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wll.inspection.dao.Company;
import com.wll.inspection.dao.RouteEquipment;
import com.wll.inspection.mapper.EquipmentMapper;
import com.wll.inspection.mapper.RouteEquipmentMapper;
import com.wll.inspection.mapper.RouteMapper;
import com.wll.inspection.service.RouteEquipmentService;
import com.wll.inspection.utils.PageRequest;
import com.wll.inspection.utils.PageResult;
import com.wll.inspection.utils.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wll
 */
@Service
@Slf4j
public class RouteEquipmentServiceImpl implements RouteEquipmentService {
    @Autowired
    RouteEquipmentMapper routeEquipmentMapper;

    @Autowired
    RouteMapper routeMapper;

    @Autowired
    EquipmentMapper equipmentMapper;

    @Override
    public List<?> selectEquipmentInRoute(Long routeId) {
        try{
            List equipment= new ArrayList<>();
            List equipments = routeEquipmentMapper.selectEquipmentInRoute(routeId);
            for(int i = 0; i<equipments.size();i++){
                equipment.add(equipmentMapper.selectByPrimaryKey((Long) equipments.get(i)));
            }
            return equipment;
        }catch(Exception e){
            return null;
        }


    }

    @Override
    public PageInfo<RouteEquipment> findAllUserByPageS(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<RouteEquipment> lists = routeEquipmentMapper.pageSelect();
        PageInfo<RouteEquipment> pageInfo = new PageInfo<RouteEquipment>(lists);
        return pageInfo;
    }

    private PageInfo<RouteEquipment> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<RouteEquipment> routeEquipments = routeEquipmentMapper.pageSelect();
        return new PageInfo<RouteEquipment>(routeEquipments);
    }
}
