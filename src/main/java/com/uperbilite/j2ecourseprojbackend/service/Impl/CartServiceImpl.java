package com.uperbilite.j2ecourseprojbackend.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.uperbilite.j2ecourseprojbackend.mapper.BookMapper;
import com.uperbilite.j2ecourseprojbackend.mapper.CartMapper;
import com.uperbilite.j2ecourseprojbackend.pojo.Book;
import com.uperbilite.j2ecourseprojbackend.pojo.Item;
import com.uperbilite.j2ecourseprojbackend.pojo.User;
import com.uperbilite.j2ecourseprojbackend.service.CartService;
import com.uperbilite.j2ecourseprojbackend.utils.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
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

    private static int getUserId() {
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        UserDetailsImpl userInfo = (UserDetailsImpl) authentication.getPrincipal();
        User user = userInfo.getUser();

        return user.getId();
    }

    /**
     * 获取用户的购物车列表
     * @return 该用户所有放入购物车的书
     */
    @Override
    public List<Book> getItemList() {
        QueryWrapper<Item> itemQueryWrapper = new QueryWrapper<>();
        itemQueryWrapper.eq("user_id", getUserId());

        List<Book> result = new ArrayList<>();

        List<Item> itemList = cartMapper.selectList(itemQueryWrapper);
        for (Item i : itemList) {
            QueryWrapper<Book> bookQueryWrapper = new QueryWrapper<>();
            bookQueryWrapper.eq("id", i.getBookId());
            result.add(bookMapper.selectOne(bookQueryWrapper));
        }

        return result;
    }

    /**
     * 清空用户的购物车
     */
    @Override
    public void clearItemList() {
        Map<String, Integer> map = new HashMap<>();
        map.put("user_id", getUserId());
        cartMapper.delete(new QueryWrapper<Item>().allEq(map));
    }

    /**
     * 把书添加到购物车
     * @param bookId 书id
     * @return 成功以及失败的信息
     */
    @Override
    public Map<String, String> addItem(int bookId) {
        Map<String, String> result = new HashMap<>();
        int userId = getUserId();

        QueryWrapper<Book> bookQueryWrapper = new QueryWrapper<>();
        bookQueryWrapper.eq("id", bookId);
        if (bookMapper.selectOne(bookQueryWrapper).getStock() == 0) {
            result.put("message", "库存数量不足");
            return result;
        }

        QueryWrapper<Item> itemQueryWrapper = new QueryWrapper<>();
        Map<String, Integer> map = new HashMap<>();
        map.put("user_id", userId);
        map.put("book_id", bookId);
        itemQueryWrapper.allEq(map);
        if (!cartMapper.selectList(itemQueryWrapper).isEmpty()) {
            result.put("message", "不能重复添加");
            return result;
        }

        cartMapper.insert(new Item(null, userId, bookId));
        result.put("message", "success");

        return result;
    }

    /**
     * 删除购物车的书
     * @param bookId 书id
     * @return 成功以及失败的信息
     */
    @Override
    public Map<String, String> delItem(int bookId) {
        Map<String, String> result = new HashMap<>();
        QueryWrapper<Item> queryWrapper = new QueryWrapper<>();
        int userId = getUserId();

        Map<String, Object> map = new HashMap<>();
        map.put("user_id", userId);
        map.put("book_id", bookId);
        queryWrapper.allEq(map);

        if (cartMapper.delete(queryWrapper) == 1) {
            result.put("message", "success");
        } else {
            result.put("message", "删除失败");
        }

        return result;
    }
}
