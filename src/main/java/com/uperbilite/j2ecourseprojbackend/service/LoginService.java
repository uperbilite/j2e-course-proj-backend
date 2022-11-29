package com.uperbilite.j2ecourseprojbackend.service;

import java.util.Map;

public interface LoginService {
    Map<String, String> getToken(String username, String password);
}
