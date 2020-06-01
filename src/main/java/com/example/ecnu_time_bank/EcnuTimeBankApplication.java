package com.example.ecnu_time_bank;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.example.ecnu_time_bank.mapper")

public class EcnuTimeBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcnuTimeBankApplication.class, args);
    }

}
