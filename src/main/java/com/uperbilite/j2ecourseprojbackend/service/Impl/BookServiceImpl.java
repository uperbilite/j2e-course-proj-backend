package com.uperbilite.j2ecourseprojbackend.service.Impl;


import com.uperbilite.j2ecourseprojbackend.mapper.BookMapper;
import com.uperbilite.j2ecourseprojbackend.pojo.Book;
import com.uperbilite.j2ecourseprojbackend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> getBookList() {
        return bookMapper.selectList(null);
    }

    @Override
    public boolean addBook(Book book) {
        return bookMapper.insert(book) == 1;
    }
}
