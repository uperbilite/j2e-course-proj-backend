package com.uperbilite.j2ecourseprojbackend.controller;

import com.uperbilite.j2ecourseprojbackend.pojo.Book;
import com.uperbilite.j2ecourseprojbackend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/cart/{id}")
    public List<Book> getAllItem(@PathVariable("id") Integer userId) {
        return cartService.getAllItem(userId);
    }

    @PostMapping("/cart/{id}")
    public Map<String, String> addCartItem(@PathVariable("id") Integer userId, @RequestBody Map<String, String> Item) {
        int bookId = Integer.parseInt(Item.get("bookId"));
        return cartService.addCartItem(userId, bookId);
    }

    @DeleteMapping("/cart/{id}")
    public Map<String, String> delCartItem(@PathVariable("id") Integer userId, @RequestBody Map<String, String> Item) {
        int bookId = Integer.parseInt(Item.get("bookId"));
        return cartService.delCartItem(userId, bookId);
    }
}
