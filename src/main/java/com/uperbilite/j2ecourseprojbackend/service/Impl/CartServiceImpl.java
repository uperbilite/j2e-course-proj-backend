package com.uperbilite.j2ecourseprojbackend.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.uperbilite.j2ecourseprojbackend.mapper.BookMapper;
import com.uperbilite.j2ecourseprojbackend.mapper.CartMapper;
import com.uperbilite.j2ecourseprojbackend.pojo.Book;
import com.uperbilite.j2ecourseprojbackend.pojo.Item;
import com.uperbilite.j2ecourseprojbackend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> getAllItem(int userId) {
        QueryWrapper<Item> itemQueryWrapper = new QueryWrapper<>();
        itemQueryWrapper.eq("user_id", userId);

        List<Book> result = new ArrayList<>();

        List<Item> allBookFromUser = cartMapper.selectList(itemQueryWrapper);
        for (Item i : allBookFromUser) {
            QueryWrapper<Book> bookQueryWrapper = new QueryWrapper<>();
            bookQueryWrapper.eq("id", i.getBookId());
            result.add(bookMapper.selectOne(bookQueryWrapper));
        }

        return result;
    }

    @Override
    public Map<String, String> addCartItem(int userId, int bookId) {
        Map<String, String> result = new HashMap<>();
        if (cartMapper.insert(new Item(null, userId, bookId)) == 1) {
            result.put("message", "success");
        } else {
            result.put("message", "failed");
        }
        return result;
    }
}
