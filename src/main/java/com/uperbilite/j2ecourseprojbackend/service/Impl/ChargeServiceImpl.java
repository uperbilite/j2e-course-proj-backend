package com.uperbilite.j2ecourseprojbackend.service.Impl;

import com.uperbilite.j2ecourseprojbackend.mapper.UserMapper;
import com.uperbilite.j2ecourseprojbackend.pojo.User;
import com.uperbilite.j2ecourseprojbackend.service.ChargeService;
import com.uperbilite.j2ecourseprojbackend.utils.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChargeServiceImpl implements ChargeService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Map<String, String> charge(int amount) {
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        UserDetailsImpl userInfo = (UserDetailsImpl) authentication.getPrincipal();
        User user = userInfo.getUser();

        Map<String, String> result = new HashMap<>();

        user.setBalance(user.getBalance() + amount);
        if (userMapper.updateById(user) == 1) {
            result.put("message", "success");
        } else {
            result.put("message", "充值失败");
        }

        return result;
    }
}
