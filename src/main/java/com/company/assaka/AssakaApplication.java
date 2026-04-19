package com.company.assaka;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.company.assaka.mapper")
public class AssakaApplication {
    public static void main(String[] args) {
        SpringApplication.run(AssakaApplication.class, args);
    }

}
