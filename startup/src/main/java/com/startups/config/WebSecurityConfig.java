package com.startups.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	// Authentication configuration for requests
	protected void configure(HttpSecurity http) throws Exception{
		//allow h2 console
		http
			.headers().disable()
			.csrf().disable();
		http.authorizeRequests()
			.antMatchers(
					"/v1", "/dashboard").authenticated() //authenticated pages
			
			.anyRequest().permitAll()
			.and().formLogin().loginPage("/login").permitAll() // custom login and 403 pages
					.defaultSuccessUrl("/dashboard") // dashboard is the user's overview page
					.usernameParameter("email") // the user logs in with their email, not a username
			.and().exceptionHandling().accessDeniedPage("/403");
	}
	
	

	@Autowired
	DataSource dataSource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select email, password, user_enabled from user where email=?")
		.authoritiesByUsernameQuery("SELECT role_email, role_description FROM role WHERE role_email=?");
	}
	
}