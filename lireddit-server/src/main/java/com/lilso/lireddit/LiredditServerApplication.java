package com.lilso.lireddit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class LiredditServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiredditServerApplication.class, args);
	}

}
