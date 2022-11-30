package com.uperbilite.j2ecourseprojbackend.controller;

import com.uperbilite.j2ecourseprojbackend.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class InfoController {

    @Autowired
    private InfoService infoService;

    @GetMapping("/info")
    public Map<String, String> getInfo() {
        return infoService.getInfo();
    }
}
