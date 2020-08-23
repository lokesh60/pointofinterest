package com.example.pointofinterest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableCaching
@EnableFeignClients
public class PointofinterestApplication {

	public static void main(String[] args) {
		SpringApplication.run(PointofinterestApplication.class, args);
	}

}
