package io.zbc.uu.book;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAsync
@EnableTransactionManagement
@MapperScan({"io.zbc.uu.book.dao"})
@SpringBootApplication
public class UUBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(UUBookApplication.class, args);
    }

}
