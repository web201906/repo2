package com.liyuhang;

import com.liyuhang.dao.UserDao;
import com.liyuhang.domian.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class UserTest {
    private InputStream in;
    private UserDao userDao;
    private SqlSession sqlSession;
    @Before
    public void init() throws IOException {
        in= Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession(true);
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After
    public void distory() throws IOException {
        in.close();
        sqlSession.close();

    }

    @Test
    public void testFindAll(){
        List<User> users = userDao.findAll();
        for(User user : users){
            System.out.println(user);
        }
    }

    @Test
    public  void  moFuFind(){
        User user1 = new User();
        user1.setUsername("%王%");
        List<User> users = userDao.moFuFind(user1);
        for(User user : users){
            System.out.println(user);
        }
    }

    @Test
    public  void  zhiJieFind(){
        List<User> users = userDao.zhiJieFind("%小%");
        for(User user : users){
            System.out.println(user);
        }
    }

    @Test
    public  void  conditionFind(){
        User user1 = new User();
        user1.setUsername("%王%");
        user1.setSex("男");
        List<User> users = userDao.conditionFind(user1);
        for(User user : users){
            System.out.println(user);
        }
    }

    @Test
    public  void  findInIds(){
        User user1 = new User();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(41);
        ids.add(48);
        user1.setIds(ids);
        List<User> users = userDao.findInIds(user1);
        for(User user : users){
            System.out.println(user);
        }
    }

}
