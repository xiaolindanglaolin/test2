package com.example.lyhfirstproject.entity;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Combine1 {
    public String user_name;
    public Integer gender;
    public Date birthday;
    public Integer dept_id;
    public String description;
    public String address;

    public Combine1(String user_name, Integer gender, Date birthday, Integer dept_id, String description, String address) {
        this.user_name = user_name;
        this.gender = gender;
        this.birthday = birthday;
        this.dept_id = dept_id;
        this.description = description;
        this.address = address;
    }
    public Combine1() {

    }


    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

