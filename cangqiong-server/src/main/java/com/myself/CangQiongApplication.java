package com.myself;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class CangQiongApplication {
    public static void main(String[] args) {
        SpringApplication.run(CangQiongApplication.class, args);
        log.info("CangQiongApplication Started");
    }
}
