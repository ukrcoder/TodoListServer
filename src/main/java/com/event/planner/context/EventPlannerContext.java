package com.event.planner.context;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Anton Shvechikov on 23.02.16.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.event.planner.service", "com.event.planner.controller"})
@EnableJpaRepositories(basePackages = "com.event.planner.repository")
public class EventPlannerContext extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(EventPlannerContext.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(EventPlannerContext.class);
    }
}
