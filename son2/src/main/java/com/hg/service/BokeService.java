package com.hg.service;

import com.hg.entity.Boke;

import java.util.List;

/**
 * Created by 888 on 2019/11/14.
 */
public interface BokeService {
    List<Boke> queryAll();

    List<Boke> queryMany(Integer page, Integer rows);//分页查询

    Boke queryById(String id);

    void update(Boke boke);

    void add(Boke boke);

    void delete(String id);
}
