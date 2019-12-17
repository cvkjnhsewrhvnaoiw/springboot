package com.hg.service;

import com.hg.entity.User;

/**
 * Created by 888 on 2019/11/14.
 */
public interface UserService {
    User queryByUsernameAndPassword(String username, String password);
}
