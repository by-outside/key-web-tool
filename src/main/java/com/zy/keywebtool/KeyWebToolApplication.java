package com.zy.keywebtool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class KeyWebToolApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(KeyWebToolApplication.class);
        builder.headless(false).run(args);
//        if (Util.isRun()) {
//            return;
//        }
//        //启动WEB
        SpringApplication.run(KeyWebToolApplication.class, args);
    }

}
