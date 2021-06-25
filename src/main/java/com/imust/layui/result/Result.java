package com.imust.layui.result;

import lombok.Data;

/**
 * @author: Administrator
 * @date: 2021/6/17 15:05
 * @description:
 */
@Data
public class Result<T> {

    private Integer code;
    private String msg;
    private Long count;
    private T data;

    private Result(T data){
        this.data = data;
        this.code = 0;
        this.msg = "success";
    }

    private Result(){

    }

    //请求成功的回调
    public static <T> Result<T> success(T data){
        return new Result<>(data);
    }

    //请求失败的回调
    public static Result fail(){
        Result<Object> objectResult = new Result<>();
        objectResult.setCode(500100);
        objectResult.setCount(0L);
        objectResult.setMsg("fail");
        return objectResult;
    }



}
