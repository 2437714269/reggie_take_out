package com.acer;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


/**
 * @author acer
 */
@SpringBootApplication
@Slf4j
@ServletComponentScan
@MapperScan("com.acer.mapper")
public class SpringbootApplication {
    public static void main(String[] args){
        SpringApplication.run(SpringbootApplication.class,args);
        log.info("项目启动成功...");
    }
}
