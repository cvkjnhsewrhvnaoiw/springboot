package com.hg.service;

import com.hg.zhujie.Log;
import com.hg.entity.Boke;
import com.hg.mapper.BokeDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by 888 on 2019/11/14.
 */
@Service
@Transactional
@Slf4j
public class BokeServiceImpl implements BokeService {
    @Autowired
    private BokeDao bokeDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Boke> queryAll() {
        log.info("info");
        log.debug("debug");
        log.warn("warn");
        log.error("error");
        List<Boke> bokes = bokeDao.queryAll();
        return bokes;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Boke> queryMany(Integer page, Integer rows) {
        Integer start = (page-1)*rows;
        /*
        * start为当前页的第一条数据
        * rows 为每页记录数
        * */
        List<Boke> list = bokeDao.queryMany(start,rows);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Boke queryById(String id) {
        Boke boke = bokeDao.queryById(id);
        return boke;
    }

    @Override
    @Log(name= "修改博客")
    public void update(Boke boke) {
        bokeDao.update(boke);
    }

    @Override
    @Log(name = "添加博客")
    public void add(Boke boke) {
        String replace = UUID.randomUUID().toString().replace("-", "");
        boke.setTime(new Date());
        boke.setId(replace);
        bokeDao.add(boke);
    }

    @Override
    @Log(name = "删除博客")
    public void delete(String id) {
        bokeDao.delete(id);
    }
}
