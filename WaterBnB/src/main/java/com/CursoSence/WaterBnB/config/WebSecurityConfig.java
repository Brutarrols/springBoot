package com.CursoSence.WaterBnB.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.
		authorizeRequests()
			.antMatchers("/guest/**","/").permitAll()
			.antMatchers("/search**","/pools/**").access("hasRole('GUEST')")
			.antMatchers("/host/**").access("hasRole('HOST')")
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/signin")
			.permitAll()
			.and()
		.logout()
			.permitAll();
	}
}
