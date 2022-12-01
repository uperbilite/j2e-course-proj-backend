package com.uperbilite.j2ecourseprojbackend.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.uperbilite.j2ecourseprojbackend.pojo.Item;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartMapper extends BaseMapper<Item> {
}
