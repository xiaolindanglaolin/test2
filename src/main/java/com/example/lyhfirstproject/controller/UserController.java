package com.example.lyhfirstproject.controller;



import com.example.lyhfirstproject.entity.Combine1;
import com.example.lyhfirstproject.entity.Department;
import com.example.lyhfirstproject.entity.User;
import com.example.lyhfirstproject.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/Users")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);
    @GetMapping()
    public List<Combine1> GetAll(){
        return userService.getAllUsersByMapper();
    }
    @GetMapping("/{id}")
    public Combine1 GetById(@PathVariable Integer  id ){
        return userService.getUserByMapper(id);
    }
    @PostMapping()
    public String Register(@RequestBody User user){
        if((userService.RegisterByMapper(user)+0)==1){
            return "注册成功";
        }
        else{
            return "注册失败";
        }
    }
    @PutMapping()
    public String ModifyUser(@RequestBody User user){
        log.info("日志文件");
        userService.ModifyUserByMapper(user);
        return "更新成功";
    }
    @PutMapping("/s")
    public String ModifysUser(@RequestBody List<User> users){
        log.info("日志文件");
        userService.ModifyUserSByMapper(users);
        return "更新成功";
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id){
        log.info("日志文件");
        userService.deleteUserByMapper(id);
        return "删除成功!";
    }

    @DeleteMapping()
    public String deleteUsers(@RequestBody Integer[] integers){
        log.info("日志文件");
        userService.deleteUsersByMapper(integers);
        return "删除成功!";
    }
}

