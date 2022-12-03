package com.uperbilite.j2ecourseprojbackend.service;

import com.uperbilite.j2ecourseprojbackend.pojo.Book;

import java.util.List;
import java.util.Map;

public interface CartService {
    List<Book> getItemList();

    void clearItemList();

    Map<String, String> addItem(int bookId);

    Map<String, String> delItem(int bookId);
}
