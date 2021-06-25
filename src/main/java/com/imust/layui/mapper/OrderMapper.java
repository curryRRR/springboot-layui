package com.imust.layui.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imust.layui.entity.Order;
import com.imust.layui.vo.OrderAndUserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: Administrator
 * @date: 2021/6/17 11:15
 * @description:
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {


    int removeById(String orderId);
}
