package com.birdeye.chatterbox;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatterBoxApplication
{
    public static void main(String[] args)
    {
        SpringApplication app = new SpringApplication(ChatterBoxApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}