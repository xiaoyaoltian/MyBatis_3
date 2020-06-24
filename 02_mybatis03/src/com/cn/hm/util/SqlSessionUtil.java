package com.cn.hm.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
    private SqlSessionUtil() {}

    private static SqlSessionFactory sqlSessionFactory;

    static {
        String resource = "mybatis-config.xml";
        //输入流
        InputStream inputStream = null;
        try {
            //通过加载Mybatis的主配置文件mybatis-config.xml，创建输入对象
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();

    //取得SqlSession对象
    public static SqlSession getSession() {
        SqlSession session = threadLocal.get();
        if (session == null) {
            session = sqlSessionFactory.openSession();
            threadLocal.set(session);
        }

        return session;
    }

    //关闭SqlSession对象
    public static void myClose(SqlSession session) {
        if (session != null) {
            session.close();
            //必须加，非常容易忘记：线程并没有销毁，而是回到了线程池中，需要手动删除
            threadLocal.remove();
        }
    }

}
