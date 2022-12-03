package com.uperbilite.j2ecourseprojbackend.controller;

import com.uperbilite.j2ecourseprojbackend.pojo.Book;
import com.uperbilite.j2ecourseprojbackend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getBookList() {
        return bookService.getAllBooks();
    }

    @PostMapping("/books")
    public Map<String, String> addBook(@RequestBody Map<String, String> newBook) {
        String name = newBook.get("name");
        String description = newBook.get("description");
        String cover = newBook.get("cover");
        Integer price = Integer.parseInt(newBook.get("price"));
        Integer stock = 10;

        Book book = new Book(null, name, description, cover, price, stock);
        Map<String, String> result = new HashMap<>();

        if (bookService.addBook(book)) {
            result.put("message", "success");
        } else {
            result.put("message", "failed");
        }

        return result;
    }

}

