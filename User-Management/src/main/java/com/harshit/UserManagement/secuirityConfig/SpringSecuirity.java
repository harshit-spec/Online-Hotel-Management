
package com.harshit.UserManagement.secuirityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;




@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SpringSecuirity extends WebSecurityConfigurerAdapter{
@Autowired
@Qualifier(value="Manager")
private UserDetailsService userDetailsService;


	
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub

		http
		    .authorizeRequests()
		    .antMatchers("/")
		    .hasAuthority("Owner")
		    .and()
		    .authorizeRequests()
		    .antMatchers("/")
		    .hasAuthority("Manager")
		    .anyRequest()
		    .authenticated()
		    .and()
		    .httpBasic().and()
		    .cors().and()
            .csrf().disable();
		
		
	}


	@Bean
	 AuthenticationProvider authenticationProvider() {
	DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
	provider.setUserDetailsService(userDetailsService);
	provider.setPasswordEncoder(new BCryptPasswordEncoder());
	return provider;
	}
	
	
}
