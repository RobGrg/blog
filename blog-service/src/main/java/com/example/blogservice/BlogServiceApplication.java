package com.example.blogservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@OpenAPIDefinition(info = @Info(title = "Blog Service API", version = "1.0"))
public class BlogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogServiceApplication.class, args);
	}

}
