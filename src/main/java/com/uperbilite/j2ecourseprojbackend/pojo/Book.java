package com.uperbilite.j2ecourseprojbackend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String description;
    private String cover;
    private Integer price;
    private Integer stock;
}
