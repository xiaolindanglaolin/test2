package com.example.lyhfirstproject.mapper;

import com.example.lyhfirstproject.entity.Combine1;
import com.example.lyhfirstproject.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user left join department on user.dept_id = department.id")
    List<Combine1> selectAll();

    @Select("select * from user left join department on user.dept_id = department.id where user.id = #{id}")
    Combine1 selectById(Integer id );


    @Insert("insert into user(id,user_name,password,gender,birthday,dept_id) values(#{id},#{user_name},#{password},#{gender},#{birthday},#{dept_id})")
    Integer insertToUser(User user);

    @Update("update user set password=#{password} ,user_name=#{user_name},gender=#{gender},birthday=#{birthday},dept_id=#{dept_id} where id=#{id}")
    Integer update(User user);

    @Delete("delete from user where id=#{id}")
    Integer delete(Integer id);
}

