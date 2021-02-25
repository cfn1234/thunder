package com.wxadt.wxcep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * com.wxadt.wxcep
 *
 * @author caofengnian
 * @Date 2020-07-16
 */
@SpringBootApplication
public class ThunderApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ThunderApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ThunderApplication.class);
    }
}