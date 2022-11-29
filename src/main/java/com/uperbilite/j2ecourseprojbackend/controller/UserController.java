package com.uperbilite.j2ecourseprojbackend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.uperbilite.j2ecourseprojbackend.mapper.UserMapper;
import com.uperbilite.j2ecourseprojbackend.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/users")
    public List<User> getAllUser() {
        return userMapper.selectList(null);
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        return userMapper.selectOne(queryWrapper);
    }

    @PostMapping("/users")
    public String addUser() {
        return null;
    }

    @DeleteMapping("/users/{id}")
    public String delUserById(@PathVariable int id) {
        return null;
    }
}
