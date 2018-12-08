package com.startups.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TO PERMIT EVERYONE ACCESS TO EVERY RESOURCE
		//http.authorizeRequests().antMatchers("/**").permitAll();

		http
		.authorizeRequests()
			.antMatchers("/css/**", "/", "/project/**", "/pledge/**",  
				"/project/**", "/pledge/**", "/pledgeinproject/**").permitAll()
			.antMatchers("/newproject").hasAnyRole("ADMIN", "USER")
			.antMatchers("/api/**").hasRole("API")
// IT IS ALSO POSSIBLE TO SPECIFY THE TYPE OF REQUEST SO PERHAPS ALL USERS CAN USE
// GET REQUESTS BUT ONLY AUTHENTICATED ONES CAN USE POST/DELETE/PUT
//		.antMatchers(HttpMethod.GET,    "/api/**").hasAnyRole("USER", "ADMIN", "API")
//		.antMatchers(HttpMethod.DELETE, "/api/**").hasRole("API")
//		.antMatchers(HttpMethod.POST,   "/api/**").hasRole("API")
//		.antMatchers(HttpMethod.PUT,    "/api/**").hasRole("API")
		.antMatchers(                   "/actuator/**").hasRole("ADMIN")
		.antMatchers(                   "/newpledge").hasAnyRole("ADMIN", "USER")
		.anyRequest().authenticated()	
		 .and()
		    .formLogin().loginPage("/login").permitAll()	// specify that this application uses a login page through mapping /login
			//.defaultSuccessUrl("/loggedin",true)		// specify the behaviour once logged in
		    //.defaultSuccessUrl("/loggedin",true)
		    //.successHandler(new SuccessfulAuthenticationSession())
				.usernameParameter("email")			// username is not called "username" in the form but "email"
		.and()
			.httpBasic()   // can also be authenticated through HTTP request for, for example, an API request
		.and()
		.exceptionHandling().accessDeniedPage("/403");	// specify a 403 page
		//http.csrf().disable();		// required to see h2 console but otherwise leave enabled
		http.headers().frameOptions().disable();
	}


	/**
	 * The following specifies the queries for the login authentication
	 */
//	@Autowired
//	DataSource dataSource;
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
//	{
//		auth.jdbcAuthentication().dataSource(dataSource)
//		.usersByUsernameQuery("select user.userEmail, user.userPassword, user.userEnabled from user where user.userEmail=?")
//		.authoritiesByUsernameQuery("SELECT role.userEmail, role.roleDescription FROM role WHERE role.userEmail=?")
//		;
//	} 


/**
 * This section is used for creating in-memory users.	
 */
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		String encodedPassword = passwordEncoder.encode("password");
		auth.inMemoryAuthentication()
								.withUser("user").password(encodedPassword).roles("USER").and()
								.withUser("admin").password(encodedPassword).roles("USER", "ADMIN");
	}

}
