package com.imust.layui;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.imust.layui.mapper.OrderMapper;
import com.imust.layui.utils.FormatUtil;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


//@SpringBootTest
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

    //测试MP的代码生成器
    @Test
    void testGenerator(){
        GlobalConfig config = new GlobalConfig();
        //1.全局配置
        config.setActiveRecord(true) //开启AR功能
              .setAuthor("jack")    //设置作者
              .setOutputDir("D:\\workspace\\Java\\Code\\springboot_pro\\springboot+layui\\layui_monomer\\src\\main\\java") //输出目录
              .setFileOverride(true) //文件是否覆盖
              .setIdType(IdType.AUTO) //主键策略
              .setServiceName("%sService") //service接口首字母是否为I
              .setBaseResultMap(true) //
              .setBaseColumnList(true);

        //2.数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)  //指定数据库类型
                        .setDriverName("com.mysql.jdbc.Driver")
                        .setUrl("jdbc:mysql://localhost:3306/book")
                        .setUsername("root")
                        .setPassword("ronger611");

        //3.策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)  //全局大写命名
                      .setNaming(NamingStrategy.underline_to_camel)  //数据库表映射到实体命名规则
                      .setTablePrefix("t_") //表前缀
                      .setInclude("t_user"); //生成的表

        //4.包名策略配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.imust.layui") //父级包
                     .setMapper("mapper")
                     .setService("service")
                     .setController("controller")
                     .setEntity("entity")
                     .setXml("mapper");

        //5.整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(config);
        autoGenerator.setDataSource(dataSourceConfig);
        autoGenerator.setStrategy(strategyConfig);
        autoGenerator.setPackageInfo(packageConfig);
        autoGenerator.execute(); //生成代码
    }

}
