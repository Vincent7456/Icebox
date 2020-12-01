package com.ice.icebox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class IceboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(IceboxApplication.class, args);
	}
}
