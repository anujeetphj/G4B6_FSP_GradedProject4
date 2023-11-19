package com.greatlearning.employeemanagementsystemrest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	//used to configure both authentication and authorization
	@Autowired
	private MyUserDetails userDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//authentication
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(this.userDetailsService)
			.passwordEncoder(this.passwordEncoder);
		
	}
	
	
	//authorization
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.cors().disable();
		httpSecurity.csrf().disable();
		
		
		//define the rules which will tell who can access what url's
		httpSecurity
					.authorizeRequests()
					.antMatchers("/login","/api/roles","/api/users")
						.permitAll()
					.antMatchers("/api/employees",
							"/api/employees/delete/**","/api/employees/sort/**",
							"/api/employees/sort/**","/api/employees/save/**")
						.hasAnyAuthority("USER", "ADMIN")
					.anyRequest()
						.authenticated()
					.and()
						.formLogin()
					.and()
						.httpBasic()
					.and()
					.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

}