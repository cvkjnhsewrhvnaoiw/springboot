package com.hg.mapper;

import com.hg.entity.Record;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by 888 on 2019/11/15.
 */
@Mapper
public interface RecordDao {
    @Insert("insert into record values(#{id},#{peo},#{time},#{thing},#{stuta})")
    void add(Record record);
}
