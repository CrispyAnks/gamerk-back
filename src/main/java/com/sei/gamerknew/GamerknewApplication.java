package com.sei.gamerknew;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sei.gamerknew.mapper")
public class GamerknewApplication {

    public static void main(String[] args) {
        SpringApplication.run(GamerknewApplication.class, args);
    }

}
