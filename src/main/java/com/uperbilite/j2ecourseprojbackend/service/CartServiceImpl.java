package com.uperbilite.j2ecourseprojbackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.uperbilite.j2ecourseprojbackend.mapper.BookMapper;
import com.uperbilite.j2ecourseprojbackend.mapper.CartMapper;
import com.uperbilite.j2ecourseprojbackend.pojo.Book;
import com.uperbilite.j2ecourseprojbackend.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> getAllItem(int id) {
        QueryWrapper<Item> itemQueryWrapper = new QueryWrapper<>();
        itemQueryWrapper.eq("user_id", id);

        List<Book> result = new ArrayList<>();

        List<Item> allBookFromUser = cartMapper.selectList(itemQueryWrapper);
        for (Item i : allBookFromUser) {
            QueryWrapper<Book> bookQueryWrapper = new QueryWrapper<>();
            bookQueryWrapper.eq("id", i.getId());
            result.add(bookMapper.selectOne(bookQueryWrapper));
        }

        return result;
    }
}
