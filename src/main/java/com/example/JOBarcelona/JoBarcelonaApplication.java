package com.example.JOBarcelona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableAutoConfiguration
@SpringBootApplication
public class JoBarcelonaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JoBarcelonaApplication.class, args);
	}



}
