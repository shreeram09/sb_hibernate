package com.shreeram.demosb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.shreeram.demosb"})
public class DemosbApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemosbApplication.class, args);
	}	

}
