
package com.hg.cache;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationContexctAware implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static Object getBeanByClazz(Class clazz) {
        Object bean = applicationContext.getBean(clazz);
        return bean;
    }
    public static Object getBeanByName(String name) {
        Object bean = applicationContext.getBean(name);
        return bean;
    }

}

