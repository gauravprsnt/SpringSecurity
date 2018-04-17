package com.Prashant.SecuritySpring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Prashant")
                .password("hello")
                .roles("USER")
                .and()
                .withUser("gaurav").password("helloman").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/api/test").hasAnyRole("USER")
                .antMatchers("/api/admin").hasAnyRole("ADMIN")
                /*.anyRequest()
                //.permitAll()
                .fullyAuthenticated()*/
                .and().httpBasic();
        httpSecurity.csrf().disable();
    }

    @SuppressWarnings("deprecation")
    @Bean
    public static NoOpPasswordEncoder passwordEncoder(){
    return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}


