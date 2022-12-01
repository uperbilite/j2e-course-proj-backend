package com.uperbilite.j2ecourseprojbackend.service;

import com.uperbilite.j2ecourseprojbackend.pojo.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    boolean addBook(Book book);
}
