package com.uperbilite.j2ecourseprojbackend.controller;

import com.uperbilite.j2ecourseprojbackend.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CheckoutController {

    @Autowired
    private CheckoutService checkoutService;

    @PostMapping("/checkout")
    public Map<String, String> checkout() {
        return checkoutService.checkout();
    }
}
