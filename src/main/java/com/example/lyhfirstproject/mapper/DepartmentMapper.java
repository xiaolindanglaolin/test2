package com.example.lyhfirstproject.mapper;

import com.example.lyhfirstproject.entity.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface DepartmentMapper {

    // @Select("select * from department ")
    List<Department> selectAll();

    // @Select("select * from department where id = #{id}")
    Department selectById(Integer id);

    @Insert("insert into department(id,dept_name,description,address) values(#{id},#{dept_name},#{description},#{address})")
    Integer insertToDepartment(Department department);

    @Update("update department set dept_name=#{dept_name} , description=#{description},address=#{address} where id=#{id}")
    Integer update(Department department);

    @Delete("delete from department where id=#{id}")
    Integer delete(Integer id);
}

