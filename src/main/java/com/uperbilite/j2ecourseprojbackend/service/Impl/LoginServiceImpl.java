package com.uperbilite.j2ecourseprojbackend.service.Impl;

import com.uperbilite.j2ecourseprojbackend.pojo.User;
import com.uperbilite.j2ecourseprojbackend.service.LoginService;
import com.uperbilite.j2ecourseprojbackend.utils.JwtUtil;
import com.uperbilite.j2ecourseprojbackend.utils.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * 登录时获取用户的jwt token
     *
     * @param username 用户名
     * @param password 密码
     * @return jwt token
     */
    @Override
    public Map<String, String> getToken(String username, String password) {

        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(username, password);

        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        UserDetailsImpl userDetails = (UserDetailsImpl) authenticate.getPrincipal();
        User user = userDetails.getUser();

        String jwtToken = JwtUtil.createJWT(user.getId().toString());

        Map<String, String> result = new HashMap<>();
        result.put("token", jwtToken);

        return result;
    }
}
