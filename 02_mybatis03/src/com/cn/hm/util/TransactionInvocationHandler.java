package com.cn.hm.util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//动态代理模式:背
public class TransactionInvocationHandler implements InvocationHandler {

    //terget:张三
    private Object target;

    public TransactionInvocationHandler(Object target) {
        this.target = target;
    }

    //代理类的业务方法
    //invoke ：李四的表白方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SqlSession session = null;
        Object object = null;
        try {

            /*SqlSessionUtil util = new SqlSessionUtil();
            util.getSession();*///垃圾代码
            session = SqlSessionUtil.getSession();//使用类直接调方法
            //处理业务与逻辑
            //method.invoke ：张三的表白方法
            object = method.invoke(target, args);
            //处理业务逻辑后，提交事务
            session.commit();

        } catch (Exception e) {
            session.rollback();

        } finally {
            SqlSessionUtil.myClose(session);

        }


        return object;
    }

    //取得ls对象
    public Object getProxy() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}
