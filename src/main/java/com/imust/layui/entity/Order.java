package com.imust.layui.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


/**
 * @author: Administrator
 * @date: 2021/6/17 11:03
 * @description:
 */
@Data
@TableName("t_order")
public class Order {
    @TableId("order_id")
    private String orderId;
    private Date createTime;
    private BigDecimal totalPrice;
    private String status;
    private Integer userId;
}
