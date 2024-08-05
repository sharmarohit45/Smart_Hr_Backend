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
                registry.addMapping("/**") // Apply CORS settings to all endpoints
                    .allowedOrigins("https://psspl.netlify.app", "http://localhost:3000") // Specify allowed origins
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow specific methods
                    .allowedHeaders("*") // Allow all headers; consider specifying if needed
                    .allowCredentials(true); // Allow credentials
            }
        };
    }
}
