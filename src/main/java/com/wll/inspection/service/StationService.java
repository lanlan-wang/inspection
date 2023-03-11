package com.wll.inspection.service;


import com.github.pagehelper.PageInfo;
import com.wll.inspection.VO.ResultVO;
import com.wll.inspection.dao.Company;
import com.wll.inspection.dao.Project;
import com.wll.inspection.dao.Station;
import com.wll.inspection.utils.PageRequest;
import com.wll.inspection.utils.PageResult;

public interface StationService {
    ResultVO deleteStation(Long Id);

    ResultVO selectById(Long id);

    ResultVO addStation(Station record);

    ResultVO selectAll();

    PageInfo<Station> findAllUserByPageS(int pageNum, int pageSize);

    ResultVO update(Station  station);

}
