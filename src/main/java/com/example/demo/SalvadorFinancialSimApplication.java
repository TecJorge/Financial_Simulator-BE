package com.example.demo;

import com.example.demo.Utilities.SimProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class SalvadorFinancialSimApplication {
	@Autowired
	SimProperties simProperties;
	public static void main(String[] args) {
		SpringApplication.run(SalvadorFinancialSimApplication.class, args);
	}

}
