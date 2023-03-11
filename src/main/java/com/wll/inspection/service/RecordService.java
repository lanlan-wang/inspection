package com.wll.inspection.service;

import com.github.pagehelper.PageInfo;
import com.wll.inspection.VO.ResultVO;
import com.wll.inspection.dao.Company;
import com.wll.inspection.dao.Record;
import com.wll.inspection.utils.PageRequest;
import com.wll.inspection.utils.PageResult;

public interface RecordService {

    ResultVO addRecord(Record record);

    ResultVO deleteRecord(Long Id);

    ResultVO selectAll();

    ResultVO updateRecord(Record record);


    ResultVO selectById(Long Id);

    PageInfo<Record> findAllUserByPageS(int pageNum, int pageSize);
}
