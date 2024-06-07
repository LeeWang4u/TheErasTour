package com.example.theerastour;

import com.example.theerastour.Service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TheErasTourApplication {

    public static void main(String[] args) {
        SpringApplication.run(TheErasTourApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(StorageService storageService){
        return runner -> {
            storageService.init();
            System.out.println("Khoi tao thanh cong");
        };
    }

}
