package cn.itcast.travel;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.impl.IndexService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.InputStream;

public class Test {
    @Autowired
    private IndexService indexService;
    @Autowired
    private UserDao userDao;
    @org.junit.Test
    public void test() {

    }

    @org.junit.Test
    public void test2(){
        System.out.println(userDao);
        System.out.println(indexService);
    }
}
