package com.imust.layui.controller;

import com.imust.layui.mapper.OrderMapper;
import com.imust.layui.result.Result;
import com.imust.layui.service.OrderService;
import com.imust.layui.vo.OrderAndUserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * @author: Administrator
 * @date: 2021/6/17 10:33
 * @description:
 */
@Slf4j
@Controller
public class OrderController {


    @Autowired
    OrderService orderService;

    @ResponseBody
    @RequestMapping("/")
    public String hello(){
        //orderMapper.selectList(null).forEach(System.out::println);
//        userMapper.selectList(null).forEach(System.out::println);
        //orderMapper.listOrderAndUser().forEach(System.out::println);
        return "Hello World";
    }

    /**
     * 返回所有的订单信息
     * @param page 当前页数
     * @param limit 页容量
     * @return
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/orders/all")
    public Result<List<OrderAndUserVO>> listAll(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                                @RequestParam(value = "limit",defaultValue = "10") Integer limit) {
//        log.info("当前页数:{},页容量:{}",page,limit);
        //将查询所有订单信息的service方法进行了封装，status=3代表查询全部
        return orderService.orderAndUserList(page,limit,3);
    }


    /**
     * 根据订单id，先删除从表，再删除主表
     * @param orderId
     * @return
     */
    @CrossOrigin
    @ResponseBody
    @PostMapping("/orders/delete")
    public Result<String> deleteById(@RequestParam("orderId") String orderId){
        Boolean del = orderService.removeOrderById(orderId);
        if(del){
            Result<String> success = Result.success("删除成功");
            return success;
        }else{
            Result fail = Result.fail();
            fail.setData("删除失败");
            return fail;
        }
    }


    // TODO: 2021/6/17 更新订单的状态
    @CrossOrigin
    @ResponseBody
    @PostMapping("/orders/update")
    public Result<String> updateStatus(@RequestParam("status") String status,
                                       @RequestParam("orderId") String orderId){
        Boolean sta = orderService.updateOrderStatus(status, orderId);
        if(sta){
            Result<String> success = Result.success("更新状态成功");
            return success;
        }else{
            Result fail = Result.fail();
            fail.setData("更新状态失败");
            return fail;
        }
    }

    // TODO: 2021/6/18 根据条件进行筛选
    @CrossOrigin
    @ResponseBody
    @PostMapping("/orders/search")
    public Result<List<OrderAndUserVO>> orderSearchByStatus(@RequestParam("query") Integer query,
                                                            @RequestParam(value = "page",defaultValue = "1") Integer page,
                                                            @RequestParam(value = "limit",defaultValue = "10") Integer limit){
        Result<List<OrderAndUserVO>> listResult = orderService.orderAndUserList(page, limit, query);
        return listResult;
    }

}
