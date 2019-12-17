package com.hg.service;

import com.hg.entity.User;
import com.hg.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 888 on 2019/11/14.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User queryByUsernameAndPassword(String username, String password) {
        User user = userDao.queryByUsernameAndPassword(username, password);
        return user;
    }
}
