package com.wll.inspection.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wll.inspection.VO.ResultVO;
import com.wll.inspection.dao.Company;
import com.wll.inspection.dao.Station;
import com.wll.inspection.enums.ResultEnum;
import com.wll.inspection.mapper.StationMapper;
import com.wll.inspection.service.StationService;
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
public class StationServiceImpl implements StationService {
    @Autowired
    StationMapper stationMapper;
    @Override
    public ResultVO deleteStation(Long Id) {
        if(stationMapper.selectByPrimaryKey(Id) != null){
            return ResultVOUtil.error(ResultEnum.STATION_NOT_EXIST);
        }else{
            stationMapper.deleteByPrimaryKey(Id);
        }
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO selectById(Long id) {
        if(stationMapper.selectByPrimaryKey(id) == null){
            return ResultVOUtil.error(ResultEnum.STATION_NOT_EXIST);
        }
        return ResultVOUtil.success(stationMapper.selectByPrimaryKey(id));
    }

    @Override
    public ResultVO addStation(Station record) {
        if(stationMapper.selectByPrimaryKey(record.getStationId()) != null){
            return ResultVOUtil.error(ResultEnum.RECORD_HAS_EXIST);
        }
        return ResultVOUtil.success(stationMapper.insert(record));
    }

    @Override
    public ResultVO selectAll() {
        return ResultVOUtil.success(stationMapper.selectAll());
    }

    @Override
    public PageInfo<Station> findAllUserByPageS(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Station> lists = stationMapper.pageSelect();
        PageInfo<Station> pageInfo = new PageInfo<Station>(lists);
        return pageInfo;
    }

    @Override
    public ResultVO update(Station station) {
        if(stationMapper.selectByPrimaryKey(station.getStationId()) == null){
            return ResultVOUtil.error(ResultEnum.PLAN_NOT_EXIST);
        }
        return ResultVOUtil.success(stationMapper.updateByPrimaryKey(station));
    }

}
