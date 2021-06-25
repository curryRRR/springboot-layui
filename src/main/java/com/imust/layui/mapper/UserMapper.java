package com.imust.layui.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imust.layui.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: Administrator
 * @date: 2021/6/17 11:59
 * @description:
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
