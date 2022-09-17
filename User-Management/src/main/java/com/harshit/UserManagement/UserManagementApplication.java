package com.harshit.UserManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableEurekaClient
@OpenAPIDefinition(info=@Info(title="User Management API",version="1.0",description="An API used for User Management"))
public class UserManagementApplication {
@Bean

public RestTemplate restTemplate() {
	return new RestTemplate();
}
	public static void main(String[] args) {
		SpringApplication.run(UserManagementApplication.class, args);
	}

}
