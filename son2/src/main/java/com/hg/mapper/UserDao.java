package com.hg.mapper;

import com.hg.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by 888 on 2019/11/14.
 */
@Mapper
public interface UserDao {
    @Select("select id,username,password from buser")
    User queryByUsernameAndPassword(String username, String password);
}
