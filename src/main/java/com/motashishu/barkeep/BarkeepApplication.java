package com.motashishu.barkeep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BarkeepApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BarkeepApplication.class, args);
	}
}
