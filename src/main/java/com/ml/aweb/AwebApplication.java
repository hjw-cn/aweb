package com.ml.aweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.LinkedList;

@SpringBootApplication
@MapperScan("com.ml.aweb.dao")
public class AwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwebApplication.class, args);
	}
}
