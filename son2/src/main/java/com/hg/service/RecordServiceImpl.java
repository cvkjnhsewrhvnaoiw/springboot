package com.hg.service;

import com.hg.entity.Record;
import com.hg.mapper.RecordDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 888 on 2019/11/15.
 */
@Service
@Transactional
@Slf4j
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordDao recordDao;
    @Override
    public void add(Record record) {
        recordDao.add(record);
    }
}
