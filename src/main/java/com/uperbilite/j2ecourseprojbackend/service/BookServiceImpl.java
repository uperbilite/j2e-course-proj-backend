package com.uperbilite.j2ecourseprojbackend.service;


import com.uperbilite.j2ecourseprojbackend.mapper.BookMapper;
import com.uperbilite.j2ecourseprojbackend.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> getAllBooks() {
        return bookMapper.selectList(null);
    }

    @Override
    public boolean addBook(Book book) {
        return bookMapper.insert(book) == 1;
    }
}
