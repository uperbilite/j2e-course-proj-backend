package com.uperbilite.j2ecourseprojbackend.controller;

import com.uperbilite.j2ecourseprojbackend.bean.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BooksController {

    @GetMapping("/books")
    public List<Book> getBookList() {
        Book b1 = new Book(1, "book1", 100, "this is book1", "https://www.bingguner.com/upimg/allimg/191210/19-191210103310293.jpg");
        Book b2 = new Book(2, "book2", 200, "this is book2", "https://play-lh.googleusercontent.com/IeNJWoKYx1waOhfWF6TiuSiWBLfqLb18lmZYXSgsH1fvb8v1IYiZr5aYWe0Gxu-pVZX3");
        Book b3 = new Book(3, "book3", 300, "this is book3", "https://p.qqan.com/up/2022-11/202211111018317096.jpg");
        Book b4 = new Book(4, "book4", 400, "this is book4", "https://img-blog.csdnimg.cn/20181119203659334.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2xlb25hcmR3eWg3ODk=,size_16,color_FFFFFF,t_70");
        Book b5 = new Book(5, "book5", 500, "this is book5", "https://pyxis.nymag.com/v1/imgs/dea/59b/1a196ac1d3e9b1f439f309a92835943dbd-better-call-saul.rsquare.w700.jpg");
        List<Book> bookList = new ArrayList<>();
        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);
        bookList.add(b4);
        bookList.add(b5);
        return bookList;
    }

}

