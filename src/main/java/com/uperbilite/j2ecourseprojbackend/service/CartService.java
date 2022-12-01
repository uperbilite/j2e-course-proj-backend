package com.uperbilite.j2ecourseprojbackend.service;

import com.uperbilite.j2ecourseprojbackend.pojo.Book;

import java.util.List;

public interface CartService {
    List<Book> getAllItem(int id);
}
