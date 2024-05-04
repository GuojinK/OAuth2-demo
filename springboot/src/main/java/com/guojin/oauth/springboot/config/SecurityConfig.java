package com.guojin.oauth.springboot.config;

import com.guojin.oauth.springboot.security.filter.AuthenticationFilter;
import com.guojin.oauth.springboot.security.filter.JwtFilter;
import com.guojin.oauth.springboot.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig{

    @Autowired
    private JwtUtils jwtUtils;

//    @Autowired
//    private JwtFilter jwtFilter;
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    };
//    @Bean
//    public AuthenticationManager authenticationManager(
//            AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        AuthenticationManager authenticationManager =authenticationManager(http.getSharedObject(AuthenticationConfiguration.class));

        http.
                // session setting
//                .sessionManagement(session->session
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                        .maximumSessions(1)
//                )
//                .formLogin(Customizer.withDefaults())
//                .oauth2Login(Customizer.withDefaults())
////                .httpBasic(Customizer.withDefaults()).
                authorizeHttpRequests((authorization)->authorization
                        .requestMatchers("/api/register","/login","/").permitAll())
//                        .anyRequest().authenticated()
//                ).csrf(AbstractHttpConfigurer::disable)
//                .addFilter(new AuthenticationFilter(authenticationManager,jwtUtils))
//                .addFilterAfter(jwtFilter, UsernamePasswordAuthenticationFilter.class)
        ;
        return http.build();
    }



}
