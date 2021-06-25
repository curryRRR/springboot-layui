package com.imust.layui;

import com.imust.layui.mapper.OrderMapper;
import com.imust.layui.utils.FormatUtil;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@SpringBootTest
class LayuiApplicationTests {

    @Autowired
    OrderMapper orderMapper;

    @Test
    void test() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = FormatUtil.formatTime(new Date());
        String format = sdf.format(new Date());
        Date parse = sdf.parse(format);
        System.out.println(parse);
    }

    @Test
    void test2(){
        int i = orderMapper.removeById("16195106840182");
        System.out.println(i);
    }


}
