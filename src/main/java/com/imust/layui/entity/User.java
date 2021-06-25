package com.imust.layui.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author: Administrator
 * @date: 2021/6/17 11:06
 * @description:
 */
@Data
@TableName("t_user")
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
}
