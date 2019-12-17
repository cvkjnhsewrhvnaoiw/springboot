package com.hg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.SpringServletContainerInitializer;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 888 on 2019/11/14.
 */

@MapperScan(basePackages = "com.hg.mapper")
@SpringBootApplication
///@EnableRedisHttpSession
// 打war包时  extends SpringBootServletInitializer
//并且实现  configure()
public class Main{
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}
