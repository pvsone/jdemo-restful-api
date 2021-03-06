package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and().httpBasic()
                .and().oauth2ResourceServer().jwt();
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication()
                .withUser("alice").password("{noop}password").roles("USER").and()
                .withUser("betty").password("{noop}password").roles("USER").and()
                .withUser("bob").password("{noop}password").roles("USER").and()
                .withUser("charlie").password("{noop}password").roles("USER").and()
                .withUser("david").password("{noop}password").roles("USER").and()
                .withUser("zoey").password("{noop}password").roles("USER");
    }
}
