package com.uperbilite.j2ecourseprojbackend.service.Impl;

import com.uperbilite.j2ecourseprojbackend.mapper.BookMapper;
import com.uperbilite.j2ecourseprojbackend.mapper.UserMapper;
import com.uperbilite.j2ecourseprojbackend.pojo.Book;
import com.uperbilite.j2ecourseprojbackend.pojo.User;
import com.uperbilite.j2ecourseprojbackend.service.CartService;
import com.uperbilite.j2ecourseprojbackend.service.CheckoutService;
import com.uperbilite.j2ecourseprojbackend.utils.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    @Autowired
    CartService cartService;

    @Autowired
    BookMapper bookMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public Map<String, String> checkout() {
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        UserDetailsImpl userInfo = (UserDetailsImpl) authentication.getPrincipal();
        User user = userInfo.getUser();

        Map<String, String> result = new HashMap<>();

        List<Book> allBooks = cartService.getAllItem(user.getId());
        for (Book book : allBooks) {
            if (book.getStock() == 0) {
                result.put("message", "《" + book.getName() + "》的库存不足");
                return result;
            }
        }

        int totalPrice = allBooks.stream().map(Book::getPrice).reduce(0, Integer::sum);
        if (user.getBalance() < totalPrice) {
            result.put("message", "余额不足");
            return result;
        }

        // 减去余额
        user.setBalance(user.getBalance() - totalPrice);
        userMapper.updateById(user);

        // 减去库存
        for (Book book : allBooks) {
            book.setStock(book.getStock() - 1);
            bookMapper.updateById(book);
        }

        // 清空购物车
        cartService.delAllItem(user.getId());

        result.put("message", "success");

        return result;
    }
}
