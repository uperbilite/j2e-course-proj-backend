package com.uperbilite.j2ecourseprojbackend.controller;

import com.uperbilite.j2ecourseprojbackend.service.ChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ChargeController {

    @Autowired
    private ChargeService chargeService;

    @PostMapping("/charge")
    public Map<String, String> charge(@RequestBody Map<String, String> amount) {
        return chargeService.charge(Integer.parseInt(amount.get("amount")));
    }

}
