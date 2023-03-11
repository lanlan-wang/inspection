package com.wll.inspection.mapper;

import com.wll.inspection.dao.Record;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordMapper {
    int deleteByPrimaryKey(Long recordId);

    int insert(Record record);

    Record selectByPrimaryKey(Long recordId);

    List<Record> selectAll();

    int updateByPrimaryKey(Record record);

    List<Record> pageSelect();
}