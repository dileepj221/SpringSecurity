package com.coder.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	

	  @Autowired
	  private PasswordEncoder passwordEncoder;
	  
	  @Autowired
	  private UserDetailsService userDetailsService;
	  
	  @Bean
	  public PasswordEncoder passwordEncoder () {
	    return new BCryptPasswordEncoder();
	  }
	  
	  @Override
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth
	      .userDetailsService(userDetailsService)
	      .passwordEncoder(passwordEncoder);
//	      .inMemoryAuthentication()
//	      .withUser("trevor@craftycodr.com")
//	      .password("$2a$10$NLF0u1fOfWf73gQPV5l.wuvU8dh2cNtmqNznv59EIlG4oLBw5Ptx.")
//	      .roles("USER", "ADMIN");
	  }
	  
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http
	      .authorizeRequests()
	        //.antMatchers("/admin/**").hasAnyRole("ADMIN")
	      
				/**
				 * by default it add ROLE_ with the ROLE providing in the hasAnyRole method.
				 * check its implementation for more details.
				 */	        
	      .anyRequest().hasAnyRole("USER").and()
	      .formLogin()
	        .loginPage("/login")
	        .defaultSuccessUrl("/dashboard")
	        .permitAll()
	        .and()
	        .sessionManagement()
	        .maximumSessions(1);
	  }
	  
}
