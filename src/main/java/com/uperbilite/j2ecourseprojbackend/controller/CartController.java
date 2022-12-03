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

    @GetMapping("/cart")
    public List<Book> getItemList() {
        return cartService.getItemList();
    }

    @PostMapping("/cart")
    public Map<String, String> addItem(@RequestBody Map<String, String> Item) {
        int bookId = Integer.parseInt(Item.get("bookId"));
        return cartService.addItem(bookId);
    }

    @DeleteMapping("/cart")
    public Map<String, String> delItem(@RequestBody Map<String, String> Item) {
        int bookId = Integer.parseInt(Item.get("bookId"));
        return cartService.delItem(bookId);
    }
}
