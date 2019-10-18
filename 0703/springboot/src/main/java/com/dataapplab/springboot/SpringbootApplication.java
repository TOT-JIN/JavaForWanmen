package com.dataapplab.springboot;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * 
 * @author joshuaz
 * 
 * @SpringBootApplication  can be used to enable those three features, that is:
 * @EnableAutoConfiguration
 * @ComponentScan
 * @Configuration
 *
 */
@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
}
