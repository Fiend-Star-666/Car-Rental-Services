package com.intern.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;
    
    //authentication
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }

    //Authorization
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()     		
                .antMatchers("/").permitAll();
                //.and().formLogin();
        //.antMatchers("/admin").hasRole("ADMIN")
        //.antMatchers("/user").hasAnyRole("ADMIN", "USER")
    }
    
    // Bcrypt
    @Bean
	public PasswordEncoder encoder() {
    	return new BCryptPasswordEncoder();
	}
    
    /*@Bean
    public PasswordEncoder getPasswordEncoder() {
    	return NoOpPasswordEncoder.getInstance(); //Simple text password
    }*/
    
    
}