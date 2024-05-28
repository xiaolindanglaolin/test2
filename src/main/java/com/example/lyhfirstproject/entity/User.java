package com.example.lyhfirstproject.entity;


import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class User {
    public Integer id;
    public String user_name;
    public String password;
    public Integer gender;
    public Date birthday;
    public Integer dept_id;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", dept_id=" + dept_id +
                '}';
    }

    public User(Integer id, String user_name, String password, Integer gender, Date birthday, Integer dept_id) {
        this.id = id;
        this.user_name = user_name;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
        this.dept_id = dept_id;
    }
    public User() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }
}
