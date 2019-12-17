package com.hg.test;

import com.hg.Main;
import com.hg.entity.Boke;
import com.hg.mapper.BokeDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * Created by 888 on 2019/11/15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
public class Test1 {
    /*@Resource
    StringRedisTemplate stringRedisTemplate;*/
    /*@Autowired
    Bean1 bean1;*/
    @Autowired
    BokeDao bokeDao;

    @Test
    public void ttt(){
        for (int i = 0; i < 2; i++) {
            List<Boke> bokes = bokeDao.queryAll();
        }
    }
}
