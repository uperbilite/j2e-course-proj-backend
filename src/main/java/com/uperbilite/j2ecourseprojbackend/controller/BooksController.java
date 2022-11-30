package com.uperbilite.j2ecourseprojbackend.controller;

import com.uperbilite.j2ecourseprojbackend.mapper.BookMapper;
import com.uperbilite.j2ecourseprojbackend.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BooksController {

    @Autowired
    private BookMapper bookMapper;

    @GetMapping("/books")
    public List<Book> getBookList() {
        return bookMapper.selectList(null);
    }

    @PostMapping("/books")
    public Map<String, String> addBook(@RequestBody Map<String, String> newBook) {
        String name = newBook.get("name");
        Integer price = Integer.parseInt(newBook.get("price"));
        String description = newBook.get("description");
        String coverURL = newBook.get("cover");

        Book book = new Book(null, name, price, description, coverURL);
        bookMapper.insert(book);

        Map<String, String> result = new HashMap<>();
        result.put("message", "success");

        return result;
    }

}

