package com.crx.Magazine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.crx.Magazine.Models.Entities")
public class CrxMagazineApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrxMagazineApplication.class, args);
	}

}
