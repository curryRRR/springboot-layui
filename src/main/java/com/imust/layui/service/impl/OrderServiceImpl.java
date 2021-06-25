package com.imust.layui.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imust.layui.entity.Order;
import com.imust.layui.entity.User;
import com.imust.layui.mapper.OrderMapper;
import com.imust.layui.mapper.UserMapper;
import com.imust.layui.result.Result;
import com.imust.layui.service.OrderService;
import com.imust.layui.utils.FormatUtil;
import com.imust.layui.vo.OrderAndUserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Administrator
 * @date: 2021/6/17 16:21
 * @description:
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    UserMapper userMapper;

    /**
     * 将订单信息和购买者信息封装在vo进行返回
     * @return
     */
    @Override
    public Result<List<OrderAndUserVO>> orderAndUserList(Integer page, Integer limit, Integer status){
        List<OrderAndUserVO> orderAndUsers = new ArrayList<>();
//        List<Order> orders = orderMapper.selectList(null);
        //分页处理
        Page<Order> orderPage = new Page<>(page,limit);
        Page<Order> orderPageData = null;
        if(status == 0 || status == 1 || status == 2){
            //状态为 0 1 2 表示为合法的，否则都返回全部数据
            QueryWrapper<Order> orderQueryWrapper = new QueryWrapper<>();
            orderQueryWrapper.eq("status",status);
            orderPageData = orderMapper.selectPage(orderPage, orderQueryWrapper);
        }else{
            orderPageData = orderMapper.selectPage(orderPage, null);
        }
        List<Order> orders = orderPageData.getRecords();
        //将订单信息遍历封装成VO对象
        for (Order order : orders) {
            OrderAndUserVO orderAndUserVO = new OrderAndUserVO();
            BeanUtils.copyProperties(order,orderAndUserVO);
            User user = userMapper.selectById(order.getUserId()); //根据订单信息的userid查询用户名称
            if(user != null){
                orderAndUserVO.setCreateTime(FormatUtil.formatTime(order.getCreateTime()));
                orderAndUserVO.setUsername(user.getUsername());
                orderAndUserVO.setEmail(user.getEmail());
            }
            orderAndUsers.add(orderAndUserVO);
        }
        if(orderAndUsers != null && orderAndUsers.size() > 0){
            //将返回的数据进行格式的处理
            for (OrderAndUserVO orderAndUser : orderAndUsers) {
                String st = FormatUtil.parseStatus(orderAndUser.getStatus());
                orderAndUser.setStatus(st);
            }
            Result<List<OrderAndUserVO>> success = Result.success(orderAndUsers);
            success.setCount(orderPageData.getTotal());
            return success;
        }else {
            Result fail = Result.fail();
            return fail;
        }
    }


    /**
     * 通过订单id删除订单
     * @param orderId
     * @return
     */
    @Override
    public Boolean removeOrderById(String orderId) {
        if(orderId == "" || orderId.length() < 1){
            return false;
        }
        orderMapper.removeById(orderId);
        return true;
    }

    /**
     * 更新订单的状态
     * @param status
     * @param orderId
     * @return
     */
    @Override
    public Boolean updateOrderStatus(String status, String orderId) {
        if(orderId.length() > 1 && orderId != ""){
            Order order = orderMapper.selectById(orderId);
//            System.out.println(order);
            order.setStatus(status);
            int i = orderMapper.updateById(order);
            if(i >= 1){
                return true;
            }
        }
//        orderMapper.updateById()
        return false;
    }



}
