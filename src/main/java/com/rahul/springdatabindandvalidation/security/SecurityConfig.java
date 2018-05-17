package com.rahul.springdatabindandvalidation.security;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private static Logger logger= Logger.getLogger(SecurityConfig.class);
	
	//global base to give authentication to user
	
	@Autowired
	 public void configureGlobal(AuthenticationManagerBuilder auth) {
		try {
			auth
			.inMemoryAuthentication()
			.withUser("wahid").password("khan")
			.roles("USER");
		} catch (Exception e) {
			logger.error(e);
		}
	}
	
	
	protected void configure(HttpSecurity http) {
		try {
			http
			.authorizeRequests()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.and()
			.httpBasic()
			;
		} catch (Exception e) {
			logger.error(e);
		}
	}
	
	
	
	
}
