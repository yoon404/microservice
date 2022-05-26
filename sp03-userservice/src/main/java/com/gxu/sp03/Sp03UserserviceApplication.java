package com.gxu.sp03;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Administrator
 */
@SpringBootApplication
@MapperScan("com.gxu.sp03.user.mapper")
public class Sp03UserserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sp03UserserviceApplication.class, args);
    }

}
