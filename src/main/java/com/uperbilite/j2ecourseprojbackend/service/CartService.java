package com.uperbilite.j2ecourseprojbackend.service;

import com.uperbilite.j2ecourseprojbackend.pojo.Book;

import java.util.List;
import java.util.Map;

public interface CartService {
    List<Book> getAllItem(int userId);

    Map<String, String> addCartItem(int userId, int bookId);

    Map<String, String> delCartItem(int userId, int bookId);
}
