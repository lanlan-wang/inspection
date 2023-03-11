package com.wll.inspection.mapper;

import com.wll.inspection.dao.Staff;
import com.wll.inspection.dao.Station;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationMapper {
    int deleteByPrimaryKey(Long stationId);

    int insert(Station record);

    Station selectByPrimaryKey(Long stationId);

    List<Station> selectAll();

    int updateByPrimaryKey(Station record);

    List<Station> pageSelect();
}