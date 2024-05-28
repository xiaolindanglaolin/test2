package com.example.lyhfirstproject.service;

import com.example.lyhfirstproject.entity.Combine1;
import com.example.lyhfirstproject.entity.Department;
import com.example.lyhfirstproject.entity.User;
import com.example.lyhfirstproject.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<Combine1> getAllUsersByMapper() {
        return userMapper.selectAll();
    }

    @Override
    public Combine1 getUserByMapper(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public Integer RegisterByMapper(User user) {
        return userMapper.insertToUser(user);
    }

    @Override
    public Integer ModifyUserByMapper(User user) {
        return userMapper.update(user);
    }

    @Override
    public Integer ModifyUserSByMapper(List<User> users) {
        for(User user : users){
            userMapper.update(user);
        }
        return  1;
    }

    @Override
    public Integer deleteUserByMapper(Integer id) {
        return userMapper.delete(id);
    }

    @Override
    public Integer deleteUsersByMapper(Integer[] ids) {
        for(Integer id : ids){
            userMapper.delete(id);
        }
        return  1;
    }
}
