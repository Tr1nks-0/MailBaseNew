package com.tr1nksgroup.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling
@ComponentScan({
        "com.tr1nksgroup.model.config",
        "com.tr1nksgroup.controller",
        "com.tr1nksgroup.model.services",
        "com.tr1nksgroup.model.engines",
        "com.tr1nksgroup.model.components",
})
public class MainClass extends SpringBootServletInitializer {
    public static final Class[] classes = {MainClass.class,};
    public static ApplicationContext ac;

    public static void main(String[] args) {
        System.setProperty("spring.devtools.restart.enabled", "true");
        System.setProperty("spring.thymeleaf.cache", "false");
        ac = SpringApplication.run(classes, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(classes);
    }
}
