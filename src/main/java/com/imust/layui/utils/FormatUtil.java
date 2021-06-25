package com.imust.layui.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: Administrator
 * @date: 2021/6/17 15:24
 * @description:
 */
public class FormatUtil {

    //将传入的日期时间进行格式化
    public static String formatTime(Date time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format = sdf.format(time);
        return format;
    }

    //将数据中的部分字段进行翻译
    public static String parseStatus(String status){
        switch (status){
            case "0":
                return "发货中";
            case "1":
                return "物流中";
            default:
                return "已签收";
        }
    }

}
