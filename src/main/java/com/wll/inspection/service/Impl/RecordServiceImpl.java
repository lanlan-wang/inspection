package com.wll.inspection.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wll.inspection.VO.ResultVO;
import com.wll.inspection.dao.Company;
import com.wll.inspection.dao.InspectionPlan;
import com.wll.inspection.dao.Record;
import com.wll.inspection.enums.ResultEnum;
import com.wll.inspection.mapper.RecordMapper;
import com.wll.inspection.service.RecordService;
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
public class RecordServiceImpl implements RecordService {

    @Autowired
    RecordMapper recordMapper;

    @Override
    public ResultVO addRecord(Record record) {
        if(recordMapper.selectByPrimaryKey(record.getRecordId()) != null){
            return ResultVOUtil.error(ResultEnum.RECORD_HAS_EXIST);
        }
        return ResultVOUtil.success(recordMapper.insert(record));
    }

    @Override
    public ResultVO deleteRecord(Long Id) {
        if(recordMapper.selectByPrimaryKey(Id) == null){
            return ResultVOUtil.error(ResultEnum.RECORD_NOT_EXIST);
        }else{
            recordMapper.deleteByPrimaryKey(Id);
        }
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO selectAll() {
        return ResultVOUtil.success(recordMapper.selectAll());
    }

    @Override
    public ResultVO updateRecord(Record record) {
        if(recordMapper.selectByPrimaryKey(record.getRecordId()) == null){
            return ResultVOUtil.error(ResultEnum.PLAN_NOT_EXIST);
        }
        return ResultVOUtil.success(recordMapper.updateByPrimaryKey(record));
    }

    @Override
    public ResultVO selectById(Long Id) {
        if(recordMapper.selectByPrimaryKey(Id) == null){
            return ResultVOUtil.error(ResultEnum.RECORD_NOT_EXIST);
        }
        return ResultVOUtil.success(recordMapper.selectByPrimaryKey(Id));
    }

    @Override
    public PageInfo<Record> findAllUserByPageS(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Record> lists = recordMapper.pageSelect();
        PageInfo<Record> pageInfo = new PageInfo<Record>(lists);
        return pageInfo;
    }


    private PageInfo<Record> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Record> records= recordMapper.pageSelect();
        return new PageInfo<Record>(records);
    }
}
