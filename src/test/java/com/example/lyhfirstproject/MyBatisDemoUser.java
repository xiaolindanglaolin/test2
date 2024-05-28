package com.example.lyhfirstproject;

import com.example.lyhfirstproject.entity.Combine1;
import com.example.lyhfirstproject.entity.Department;
import com.example.lyhfirstproject.entity.User;
import com.example.lyhfirstproject.mapper.DepartmentMapper;
import com.example.lyhfirstproject.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
// import java.util.HashMap;
import java.util.Date;
import java.util.List;
// import java.util.Map;
public class MyBatisDemoUser {

    private static SqlSession getSqlSession(){
        //读取MyBaits的核心配置文件
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建SqlSessionFactory对象(通过创建SqlSessionFactoryBuilder来进行获取)
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //创建sqlSession对象（MyBatis的操作数据库的会话对象，通过此对象可以获取SQL语句，并执行）
        //注意：openSession对象默认是不会进行自动的事务提交的,所以我们如果想做DML操作并且自动事务提交，需要加上true参数，默认为false
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession;
    }


    @Test
    public void selectAllTest(){
        SqlSession sqlSession = MyBatisDemoUser.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<Combine1> users = userMapper.selectAll();
        users.forEach(user-> System.out.println(user));
    }



    @Test
    public void selectByIdTest(){
        SqlSession sqlSession = MyBatisDemoUser.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Combine1 user = userMapper.selectById(1);
        System.out.println(user);
    }

    @Test
    public void insertToUserTest(){
        SqlSession sqlSession = MyBatisDemoUser.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(13,"项羽","xianyu",1, new Date(1618977192000L),4);
        Integer num = userMapper.insertToUser(user);
        System.out.println(num);
    }

    @Test
    public void updateTest(){
        SqlSession sqlSession = MyBatisDemoUser.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(1,"孙悟空2","sunwukong2",1, new Date(1618977192000L),1);
        Integer num = userMapper.update(user);
        System.out.println(num);
    }
    @Test
    public void updateTests(){
        Integer num=0;
        SqlSession sqlSession = MyBatisDemoUser.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User[] users ={new User(1,"孙悟空1","sunwukong1",1, new Date(1618977192000L),1),new User(2,"猪八戒1","szhubajie1",1, new Date(1618977192000L),1)};
        for(User user : users){
            userMapper.update(user);
        }
        System.out.println(num);
    }

    @Test
    public void deleteTest(){
        SqlSession sqlSession = MyBatisDemoUser.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Integer num = userMapper.delete(1);
        System.out.println(num);
    }
    @Test
    public void deletesTest(){
        SqlSession sqlSession = MyBatisDemoUser.getSqlSession();
        UserMapper departmentMapper = sqlSession.getMapper(UserMapper.class);
        int[] array={1,2};
        Integer num=0;
        for(int user:array){
            num = departmentMapper.delete(user);
        }
        System.out.println(num);
    }
}