package com.imust.layui.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imust.layui.entity.Order;
import com.imust.layui.mapper.OrderMapper;
import com.imust.layui.result.Result;
import com.imust.layui.utils.FormatUtil;
import com.imust.layui.vo.OrderAndUserVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Administrator
 * @date: 2021/6/17 15:46
 * @description:
 */

public interface OrderService{

    /**
     * 将订单信息和购买者信息封装在vo进行返回
     * @return
     */
    Result<List<OrderAndUserVO>> orderAndUserList(Integer page, Integer limit, Integer status);

    Boolean removeOrderById(String orderId);

    Boolean updateOrderStatus(@Param("status") String status, @Param("orderId") String orderId);


}
