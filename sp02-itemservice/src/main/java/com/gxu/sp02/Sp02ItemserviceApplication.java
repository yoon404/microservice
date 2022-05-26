package com.gxu.sp02;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Administrator
 */

@SpringBootApplication
@MapperScan(basePackages = {"com.gxu.sp02.item.mapper"})
public class Sp02ItemserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sp02ItemserviceApplication.class, args);
    }

}
