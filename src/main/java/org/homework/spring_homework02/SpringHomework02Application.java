package org.homework.spring_homework02;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("org.homework.spring_homework02.repository")
@SpringBootApplication
public class SpringHomework02Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringHomework02Application.class, args);
    }

}
