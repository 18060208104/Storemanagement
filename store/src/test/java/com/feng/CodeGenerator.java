package com.feng;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.Date;

public class CodeGenerator {
    public static void main(String[] args) {
        //构建一个 代码自动生成器 对象
        AutoGenerator mpg  = new AutoGenerator();
        //配置策略

        //1、全局配置
        GlobalConfig gc = new GlobalConfig();
        //获取输出目录
        String projectPath = System.getProperty("user.dir");
        //生成的代码所在的位置
        gc.setOutputDir(projectPath+"/src/main/java");
        //作者的名字
        gc.setAuthor("fwf");
        gc.setOpen(false);
        //是否覆盖
        gc.setFileOverride(false);
        //去掉Service的I 前缀
        gc.setServiceName("%sService");
        gc.setIdType(IdType.ID_WORKER);
        gc.setDateType(DateType.ONLY_DATE);
        //gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/store?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("sys");
        pc.setParent("com.feng");
        pc.setEntity("domain");
        pc.setService("service");
        pc.setMapper("mapper");
        pc.setController("controller");
        mpg.setPackageInfo(pc);

        //4、策略配置
        StrategyConfig strategy = new StrategyConfig();


        strategy.setInclude("sys_dept");//设置要映射的表  对应数据库的表 就可以直接生成一系列方法


        strategy.setNaming(NamingStrategy.underline_to_camel);//驼峰命名
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);//lombok
        strategy.setRestControllerStyle(true);
        //逻辑删除
        strategy.setLogicDeleteFieldName("deleted");
        //自动填充策略
        TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
        TableFill gmtModified = new TableFill("gmt_modified", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> list = new ArrayList<>();
        list.add(gmtCreate);
        list.add(gmtModified);
        strategy.setTableFillList(list);
        //乐观锁
        strategy.setVersionFieldName("version");
        //rest 风格 开启驼峰命名
        strategy.setRestControllerStyle(true);
        //controller 请求多字段连接 实现下划线连接 eg：localhost:8080/aa_bb
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);
        //执行
        mpg.execute();
    }
}
