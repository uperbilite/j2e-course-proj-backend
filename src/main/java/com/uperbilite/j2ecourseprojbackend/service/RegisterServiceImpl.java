package com.uperbilite.j2ecourseprojbackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.uperbilite.j2ecourseprojbackend.mapper.UserMapper;
import com.uperbilite.j2ecourseprojbackend.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Map<String, String> register(String username, String password, String confirmedPassword) {

        Map<String, String> result = new HashMap<>();

        if (username == null) {
            result.put("message", "用户名不能为空");
            return result;
        }
        if (password == null || confirmedPassword == null) {
            result.put("message", "密码不能为空");
            return result;
        }

        username = username.trim();
        if (username.length() == 0) {
            result.put("message", "用户名不能为空");
            return result;
        }
        if (password.length() == 0 || confirmedPassword.length() == 0) {
            result.put("message", "密码不能为空");
            return result;
        }

        if (username.length() > 255) {
            result.put("message", "用户名太长");
            return result;
        }
        if (password.length() > 255 || confirmedPassword.length() > 255) {
            result.put("message", "密码太长");
            return result;
        }

        if (!password.equals(confirmedPassword)) {
            result.put("message", "两次输入的密码不一致");
            return result;
        }

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        List<User> userList = userMapper.selectList(queryWrapper);
        if (!userList.isEmpty()) {
            result.put("message", "用户名已存在");
            return result;
        }

        String encodedPassword = passwordEncoder.encode(password);
        User user = new User(null, username, encodedPassword);
        userMapper.insert(user);

        result.put("message", "success");

        return result;
    }
}
