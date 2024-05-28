package com.example.lyhfirstproject.service;

import com.example.lyhfirstproject.entity.Department;
import com.example.lyhfirstproject.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public List<Department> getAllDepartmentsByMapper() {
        return departmentMapper.selectAll();
    }

    @Override
    public Department getDepartmentByMapper(Integer id) {
        return departmentMapper.selectById(id);
    }

    @Override
    public Integer RegisterByMapper(Department department) {
        return departmentMapper.insertToDepartment(department);
    }

    @Override
    public Integer ModifyDepartmentByMapper(Department department) {
        return departmentMapper.update(department);
    }
    public Integer ModifyDepartmentsByMapper(List<Department> departments) {
        for(Department department : departments){
            departmentMapper.update(department);
        }
        return 1;
    }

    @Override
    public Integer deleteDepartmentByMapper(Integer id) {
        return  departmentMapper.delete(id);
    }

    @Override
    public Integer deleteDepartmentsByMapper(Integer[] ids) {
        for(Integer id : ids){
            departmentMapper.delete(id);
        }
        return  1;
    }
}
