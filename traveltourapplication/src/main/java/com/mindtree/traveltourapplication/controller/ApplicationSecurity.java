package com.mindtree.traveltourapplication.controller;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableOAuth2Sso
@EnableWebSecurity
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
             http.antMatcher("/**").authorizeRequests().antMatchers("/", "/callback","/signup","/display","/signin","/displayBooking","/registerUser","/loginUser","/addBooking","/update","/editBooking").permitAll().anyRequest().authenticated();
}
}