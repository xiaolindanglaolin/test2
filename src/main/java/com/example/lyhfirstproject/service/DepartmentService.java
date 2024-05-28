package com.example.lyhfirstproject.service;

import com.example.lyhfirstproject.entity.Department;

import java.util.List;

public interface DepartmentService {
    //获取所有数据
    public List<Department> getAllDepartmentsByMapper();

    //通过userName进行数据获取
    public Department getDepartmentByMapper(Integer id);

    //添加用户
    public Integer RegisterByMapper(Department department);

    //更新用户
    public Integer ModifyDepartmentByMapper(Department department);
    public Integer ModifyDepartmentsByMapper(List<Department> departments);

    //通过userName进行删除数据
    public Integer deleteDepartmentByMapper(Integer id);

    public Integer deleteDepartmentsByMapper(Integer[] ids);

}


