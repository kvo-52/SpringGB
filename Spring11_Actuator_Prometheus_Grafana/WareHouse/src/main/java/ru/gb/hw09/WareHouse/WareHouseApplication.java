package ru.gb.hw09.WareHouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WareHouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(WareHouseApplication.class, args);
	}

}
