
package com.hg.cache;

import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.locks.ReadWriteLock;

public class MyCache implements Cache {
    private String id;
    @Override
    public String getId() {
        return this.id;
    }

    public MyCache(String id) {
        this.id = id;
    }

    @Override
    public void putObject(Object o, Object o1) {
        //从容其中获取redisTemplate
        RedisTemplate redisTemplate = (RedisTemplate) MyApplicationContexctAware.getBeanByName("redisTemplate");
        redisTemplate.opsForHash().put(id,o,o1);

    }

    @Override
    public Object getObject(Object o) {
        RedisTemplate redisTemplate = (RedisTemplate) MyApplicationContexctAware.getBeanByName("redisTemplate");
        Object o1 = redisTemplate.opsForHash().get(id, o);
        return o1;
    }

    @Override
    public Object removeObject(Object o) {
        return null;
    }

    @Override
    public void clear() {
        RedisTemplate redisTemplate = (RedisTemplate) MyApplicationContexctAware.getBeanByName("redisTemplate");
        redisTemplate.opsForHash().delete(id);
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }
}

