package com.imust.layui;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//单体版应用

@SpringBootApplication
public class LayuiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LayuiApplication.class, args);
    }

}
