package com.example.lyhfirstproject;

import com.example.lyhfirstproject.entity.Department;
import com.example.lyhfirstproject.mapper.DepartmentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
public class MyBatisDemoDepartment {

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
        SqlSession sqlSession = MyBatisDemoDepartment.getSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        List<Department> departments = departmentMapper.selectAll();
        departments.forEach(department-> System.out.println(department));
    }

    @Test
    public void selectByIdTest(){
        SqlSession sqlSession = MyBatisDemoDepartment.getSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        Department department = departmentMapper.selectById(1);
        System.out.println(department);
    }

    @Test
    public void insertToUserTest(){
        SqlSession sqlSession = MyBatisDemoDepartment.getSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        Department department = new Department(5,"项目经理","软件开发","205");
        Integer num = departmentMapper.insertToDepartment(department);
        System.out.println(num);
    }

    @Test
    public void updateTest(){
        SqlSession sqlSession = MyBatisDemoDepartment.getSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        Department department = new Department(1,"前端工程师22","主要负责页面的开发22","201");
        Integer num = departmentMapper.update(department);
        System.out.println(num);
    }

    @Test
    public void updateTests(){
        Integer num =0;
        SqlSession sqlSession = MyBatisDemoDepartment.getSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        Department[] departments = {new Department(1,"前端工程师11","主要负责页面的开发11","201"),new Department(2,"后端工程师11","主要负责业务和数据处理11","202")};
        for(Department department:departments){
            num = departmentMapper.update(department);
        }
        System.out.println(num);
    }

    @Test
    public void deleteTest(){
        SqlSession sqlSession = MyBatisDemoDepartment.getSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        Integer num = departmentMapper.delete(5);
        System.out.println(num);
    }

    @Test
    public void deletesTests(){
        SqlSession sqlSession = MyBatisDemoDepartment.getSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        int[] array={5,6};
        Integer num=0;
        for(int t:array){
            num = departmentMapper.delete(t);
        }
        System.out.println(num);
    }
}