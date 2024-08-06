package com.youtube.jwt.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") 
                    .allowedOrigins(
                        "https://psspl.netlify.app",
                        "http://localhost:3000","https://psspl-rohit-sharmas-projects-fc9e49f6.vercel.app",
                        "https://psspl.vercel.app/"
                    ) 
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                     .allowedHeaders("Content-Type", "Authorization", "Accept", "X-Requested-With")
                    .allowedHeaders("*") 
                    .allowCredentials(true); 
            }
        };
    }
}
