package com.wll.inspection.service;


import com.github.pagehelper.PageInfo;
import com.wll.inspection.VO.ResultVO;
import com.wll.inspection.dao.Company;
import com.wll.inspection.dao.RouteEquipment;
import com.wll.inspection.utils.PageRequest;
import com.wll.inspection.utils.PageResult;

import java.util.List;

/**
 * @author wll
 */
public interface RouteEquipmentService {

    /**
     * 查找指定路线下的设备
     * @param routeId
     * @return
     */
    List<?> selectEquipmentInRoute(Long routeId);


    PageInfo<RouteEquipment> findAllUserByPageS(int pageNum, int pageSize);
}
