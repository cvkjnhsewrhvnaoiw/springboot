package com.hg.aspect;

import com.hg.entity.Record;
import com.hg.entity.User;
import com.hg.service.RecordService;
import com.hg.zhujie.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

/**
 * Created by 888 on 2019/11/15.
 */
@Aspect//切面
@Component
public class AroundMethod {
    @Autowired
    private RecordService recordService;
    @Autowired
    private HttpServletRequest request;

    //切入点
    @Pointcut(value = "@annotation(com.hg.zhujie.Log)")
    public void pt(){}

    //通知
    @Around(value = "pt()")
    public Object listening(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String work = "操作成功";

        //获取管理员对象
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String username = user.getUsername();

        //获取方法名
        Signature signature = proceedingJoinPoint.getSignature();// void com.hg.service.BokeServiceImpl.delete   ( String)
        String name = signature.getName();

        //方法对象
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();//实现类方法对象public void com.hg.service.BokeServiceImpl.delete(java.lang.String)
        Method method = methodSignature.getMethod();

        //通过方法对象  获取方法上的注解
        Log annotation = method.getAnnotation(Log.class);//@com.hg.zhujie.Log(name=删除博客)
        String name1 = annotation.name();//自定义方法名
        Record record = new Record();

        Object proceed = null;
        try {
            record.setId(UUID.randomUUID().toString().replace("-",""));
            record.setPeo(username);
            record.setStuta(work);
            record.setThing(name1);
            Record record1 = record.setTime(new Date());

            proceed = proceedingJoinPoint.proceed();//方法的返回值  并且放行

            System.out.println(record1);
            return proceed;
        } catch (Throwable throwable) {
            work="操作失败";
            record.setStuta(work);
            throw throwable;
        }finally {
            recordService.add(record);
            System.out.println(name);
            System.out.println(proceed);
            System.out.println(signature);
            System.out.println(name1);
            System.out.println(methodSignature);
            System.out.println(method);
            System.out.println(annotation);
        }
    }
}
