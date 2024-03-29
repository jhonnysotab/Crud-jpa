package com.jhonnysota.springboot.app.springbootcrud.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.jhonnysota.springboot.app.springbootcrud.config;

@Configuration
public class SpringSecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity.authorizeHttpRequests((auth )-> auth
                                    .requestMatchers("/users")
                                    .permitAll()
                                    .anyRequest()
                                    .authenticated())
                                    .csrf(config-> config.disable())
                                    .sessionManagement(management->management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                                    .build();
    }
}
