package com.example.lyhfirstproject.service;

import com.example.lyhfirstproject.entity.Combine1;
import com.example.lyhfirstproject.entity.Department;
import com.example.lyhfirstproject.entity.User;

import java.util.List;

public interface UserService {
    //获取所有数据
    public List<Combine1> getAllUsersByMapper();

    //通过id进行数据获取
    public Combine1 getUserByMapper(Integer id);

    //添加用户
    public Integer RegisterByMapper(User user);

    //更新用户
    public Integer ModifyUserByMapper(User user);
    //批量更新用户
    public Integer ModifyUserSByMapper(List<User> user);

    //通过id进行删除数据
    public Integer deleteUserByMapper(Integer id);

    //批量删除
    public Integer deleteUsersByMapper(Integer[] id);

}

