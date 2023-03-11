package com.wll.inspection.service;

import com.github.pagehelper.PageInfo;
import com.wll.inspection.VO.ResultVO;
import com.wll.inspection.dao.Company;
import com.wll.inspection.dao.Route;
import com.wll.inspection.utils.PageRequest;
import com.wll.inspection.utils.PageResult;

public interface RouteService {

    ResultVO deleteByPrimaryKey(Long RouteId);

    ResultVO selectById(Long id);

    ResultVO addRoute(Route record);

    ResultVO selectAll();

    PageInfo<Route> findAllUserByPageS(int pageNum, int pageSize);

    ResultVO update(Route route);
}
