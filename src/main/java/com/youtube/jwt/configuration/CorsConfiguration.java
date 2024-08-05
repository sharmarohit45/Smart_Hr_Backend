package com.youtube.jwt.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {

    private static final String GET = "GET";
    private static final String POST = "POST";
    private static final String PUT = "PUT";
    private static final String DELETE = "DELETE";

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                    .allowedOrigins("http://localhost:3000", "https://psspl.netlify.app") // Exact origin URLs
                    .allowedMethods(GET, POST, PUT, DELETE)
                    .allowedHeaders("*") // Allows all headers; consider specifying if you need stricter control
                    .allowCredentials(true); // Allow credentials to be sent with requests
            }
        };
    }
}
