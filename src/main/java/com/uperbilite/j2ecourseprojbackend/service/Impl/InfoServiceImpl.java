package com.uperbilite.j2ecourseprojbackend.service.Impl;

import com.uperbilite.j2ecourseprojbackend.pojo.User;
import com.uperbilite.j2ecourseprojbackend.service.InfoService;
import com.uperbilite.j2ecourseprojbackend.utils.UserDetailsImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InfoServiceImpl implements InfoService {

    @Override
    public Map<String, String> getInfo() {

        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        UserDetailsImpl userInfo = (UserDetailsImpl) authentication.getPrincipal();
        User user = userInfo.getUser();

        Map<String, String> result = new HashMap<>();
        result.put("message", "success");
        result.put("id", user.getId().toString());
        result.put("username", user.getUsername());

        return result;
    }
}
