package com.imust.layui.vo;

import com.imust.layui.entity.Order;
import com.imust.layui.entity.User;
import lombok.Data;
import org.springframework.data.relational.core.sql.In;

import java.math.BigDecimal;
import java.util.Date;


/**
 * @author: Administrator
 * @date: 2021/6/17 14:52
 * @description:
 */
@Data
public class OrderAndUserVO {
    private String orderId;
    private String createTime;
    private BigDecimal totalPrice;
    private String username;
    private String email;
    private String status;

}
