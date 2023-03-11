package com.wll.inspection.mapper;

import com.wll.inspection.dao.Route;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wll
 */
@Repository
public interface RouteMapper {
    int deleteByPrimaryKey(Long routeId);

    int insert(Route record);

    Route selectByPrimaryKey(Long routeId);

    List<Route> selectAll();

    int updateByPrimaryKey(Route record);

    List<Route> pageSelect();
}