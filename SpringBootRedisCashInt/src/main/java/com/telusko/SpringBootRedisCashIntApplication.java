package com.telusko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootRedisCashIntApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRedisCashIntApplication.class, args);
    }

}
