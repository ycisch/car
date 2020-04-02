package com.project.service.impl;

import com.project.mapper.RecordMapper;
import com.project.model.Order;
import com.project.model.Record;
import com.project.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: car
 * @description:
 * @author: Administrator
 * @create: 2020-03-29 23:32
 */
@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    RecordMapper recordMapper;

    @Override
    public List<Record> findAllRecord(Record record) {
        return recordMapper.findAllRecord(record);
    }

    @Override
    public int insertRecord(Record record) {
        return recordMapper.insertRecord(record);
    }

    @Override
    public int updateRecord(Record record) {
        return recordMapper.updateRecord(record);
    }

    @Override
    public int deleteRecord(Integer[] ids) {
        return recordMapper.deleteRecord(ids);
    }
}
