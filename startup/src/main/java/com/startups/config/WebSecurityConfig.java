package com.startups.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	
	// Authentication configuration for requests
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			.antMatchers(
					"/", "/css/**" , "/allprojects", "/projectdetails") .permitAll() //unauthenticated pages
			
			.anyRequest().authenticated()
			
			.and().formLogin().loginPage("/login").permitAll() // custom login and 403 pages
					.defaultSuccessUrl("/dashboard") // dashboard is the user's overview page
					.usernameParameter("email") // the user logs in with their email, not a username
			.and().exceptionHandling().accessDeniedPage("/403"); 
	}
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		String encodedPassword = this.passwordEncoder.encode("password");
		
		auth.inMemoryAuthentication() // this is only auth'ing based on a generic user with name "user" and password "pasword"
			.withUser("user").password(encodedPassword).roles("USER").and()
			.withUser("admin").password(encodedPassword).roles("USER","ADMIN");
	}

	
	
	
}