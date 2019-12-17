package com.hg.mapper;

import com.hg.entity.Boke;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by 888 on 2019/11/14.
 */
@Mapper
public interface BokeDao {

    List<Boke> queryAll();

    List<Boke> queryMany(@Param("start") Integer start,@Param("rows") Integer rows);

    @Select("select id,titel,content,time from boke where id=#{id}")
    Boke queryById(@Param("id") String id);

    @Update("update boke set titel=#{titel},content=#{content} where id = #{id}")
    void update(Boke boke);
    @Insert("insert into boke values(#{id},#{titel},#{content},#{time})")
    void add(Boke boke);
    @Delete("delete from boke where id=#{id}")
    void delete(@Param("id") String id);
}
