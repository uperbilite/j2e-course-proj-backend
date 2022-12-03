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
    public List<Book> getItemList(@PathVariable("id") Integer userId) {
        return cartService.getItemList(userId);
    }

    @PostMapping("/cart/{id}")
    public Map<String, String> addItem(@PathVariable("id") Integer userId, @RequestBody Map<String, String> Item) {
        int bookId = Integer.parseInt(Item.get("bookId"));
        return cartService.addItem(userId, bookId);
    }

    @DeleteMapping("/cart/{id}")
    public Map<String, String> delItem(@PathVariable("id") Integer userId, @RequestBody Map<String, String> Item) {
        int bookId = Integer.parseInt(Item.get("bookId"));
        return cartService.delItem(userId, bookId);
    }
}
