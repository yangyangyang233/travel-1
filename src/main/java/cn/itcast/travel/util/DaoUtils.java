package cn.itcast.travel.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DaoUtils {
    public static SqlSession getSession() {

        SqlSession session = null;
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            // 然后根据 sqlSessionFactory 得到 session
            session = sqlSessionFactory.openSession();
        }catch (IOException e){

        }


        return session;
        //UserDao userDao = session.getMapper(UserDao.class);
    }
}
