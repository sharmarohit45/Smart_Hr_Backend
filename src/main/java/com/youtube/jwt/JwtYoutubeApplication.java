package com.youtube.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.youtube.jwt.dao")
@CrossOrigin(origins = "https://psspl.netlify.app/")
public class JwtYoutubeApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtYoutubeApplication.class, args);
        //jfghfj fghfg khgdkg khfdk
    }

}
