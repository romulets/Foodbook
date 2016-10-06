package com.foodbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration 
	extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService usuarioService;
	
	@Override
	public void configure(AuthenticationManagerBuilder builder) 
			throws Exception{
		builder.userDetailsService(usuarioService)
			   .passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.authorizeRequests()
				 .antMatchers("/register").permitAll()
				 .antMatchers("/resources/**").permitAll()
				 .anyRequest().authenticated()
				 .and()
			.formLogin()
				 .loginPage("/").permitAll()
		    	 .and()
		    .logout()
		         .permitAll()
		         .and()
		    .exceptionHandling()
		    	 .accessDeniedPage("/WEB-INF/views/timeline")
		    	 .and()
		    .csrf()
		    	 .disable();
	}

}
