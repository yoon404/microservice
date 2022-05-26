package com.gxu.sp04;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gxu.sp04.order.mapper")
public class Sp04OrderserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sp04OrderserviceApplication.class, args);
    }

}
