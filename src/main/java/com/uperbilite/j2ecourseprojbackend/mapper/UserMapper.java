package com.uperbilite.j2ecourseprojbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.uperbilite.j2ecourseprojbackend.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
