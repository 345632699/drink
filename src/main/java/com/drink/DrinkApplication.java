package com.drink;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.drink.mapper")
@ComponentScan(basePackages={"com.drink.*"})
public class DrinkApplication {

    public static void main(String[] args) {
        SpringApplication.run(DrinkApplication.class, args);
    }

}
