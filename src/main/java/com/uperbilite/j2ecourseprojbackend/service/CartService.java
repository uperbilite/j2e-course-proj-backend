package com.uperbilite.j2ecourseprojbackend.service;

import com.uperbilite.j2ecourseprojbackend.pojo.Book;

import java.util.List;
import java.util.Map;

public interface CartService {
    List<Book> getItemList(int userId);

    void clearItemList(int userId);

    Map<String, String> addItem(int userId, int bookId);

    Map<String, String> delItem(int userId, int bookId);
}
