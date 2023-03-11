package com.wll.inspection.mapper;

import com.wll.inspection.dao.RouteEquipment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wll
 */
@Repository
public interface RouteEquipmentMapper {

    int deleteByPrimaryKey(@Param("tableId") Long tableId, @Param("routeId") Long routeId);

    int insert(RouteEquipment record);

    RouteEquipment selectByPrimaryKey(@Param("tableId") Long tableId, @Param("routeId") Long routeId);

    List<RouteEquipment> selectAll();

    int updateByPrimaryKey(RouteEquipment record);

    RouteEquipment selectByEquipmentId(Long equipmentId);

    /**
     * 分页查询
     * @return
     */
    List<RouteEquipment> pageSelect();
    /**
     * 通过路线Id查找到设备Id
     * @param routeId
     * @return
     */
    List<Long> selectEquipmentInRoute(Long routeId);
}