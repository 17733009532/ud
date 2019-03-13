package com.baihi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

@Configuration
@SpringBootApplication
@MapperScan(value="com.baihi.dao")
public class UdApplication {

    public static void main(String[] args) {
        SpringApplication.run(UdApplication.class, args);
        System.out.println("456");
        System.out.println("123");
    }

}
