package com.msil.systemTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SystemTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemTaskApplication.class, args);
		System.out.println("running.....");
	}

}
