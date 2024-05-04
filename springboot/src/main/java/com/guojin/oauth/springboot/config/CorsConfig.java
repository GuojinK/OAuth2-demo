package com.guojin.oauth.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    private static final String ALLOW_ORIGIN_URL = "http://localhost:3000";
    private static final String EXPOSED_HEADER = "access_token";
    private static final String[] ALLOW_METHODS = {"POST","GET","PUT","DELETE"};


    private CorsConfiguration buildConfig(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin(ALLOW_ORIGIN_URL);
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.setAllowedMethods(Arrays.asList(ALLOW_METHODS));
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addExposedHeader(EXPOSED_HEADER);
        return corsConfiguration;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(ALLOW_ORIGIN_URL)
                .allowedMethods(ALLOW_METHODS)
                .maxAge(3600);
    }
}
