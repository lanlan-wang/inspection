package com.wll.inspection.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wll.inspection.VO.ResultVO;
import com.wll.inspection.dao.Company;
import com.wll.inspection.dao.Route;
import com.wll.inspection.dao.Staff;
import com.wll.inspection.enums.ResultEnum;
import com.wll.inspection.mapper.RouteMapper;
import com.wll.inspection.service.RouteService;
import com.wll.inspection.utils.PageRequest;
import com.wll.inspection.utils.PageResult;
import com.wll.inspection.utils.PageUtils;
import com.wll.inspection.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RouteServiceImpl implements RouteService {
    @Autowired
    RouteMapper routeMapper;

    @Override
    public ResultVO deleteByPrimaryKey(Long RouteId) {
        if(routeMapper.selectByPrimaryKey(RouteId) == null){
            return ResultVOUtil.error(ResultEnum.ROUTE_NOT_EXIST);
        }
        routeMapper.deleteByPrimaryKey(RouteId);
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO selectById(Long id) {
        if(routeMapper.selectByPrimaryKey(id) == null){
            return ResultVOUtil.error(ResultEnum.ROUTE_NOT_EXIST);
        }
        return ResultVOUtil.success(routeMapper.selectByPrimaryKey(id));
    }

    @Override
    public ResultVO addRoute(Route record) {
        if(routeMapper.selectByPrimaryKey(record.getRouteId()) != null){
            return ResultVOUtil.error(ResultEnum.ROUTE_HAS_EXIST);
        }
        routeMapper.insert(record);
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO selectAll() {
        return ResultVOUtil.success(routeMapper.selectAll());
    }

    @Override
    public PageInfo<Route> findAllUserByPageS(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Route> lists = routeMapper.pageSelect();
        PageInfo<Route> pageInfo = new PageInfo<Route>(lists);
        return pageInfo;
    }


    @Override
    public ResultVO update(Route route) {
        if(routeMapper.selectByPrimaryKey(route.getRouteId()) == null){
            return ResultVOUtil.error(ResultEnum.ROUTE_NOT_EXIST);
        }
        return ResultVOUtil.success(routeMapper.updateByPrimaryKey(route));
    }


}
