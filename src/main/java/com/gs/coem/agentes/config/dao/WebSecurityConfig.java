package com.gs.coem.agentes.config.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{


	@Bean
	protected CorsConfigurationSource corsConfigurationSource() {
		//UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		//source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		//
		CorsConfiguration configuration = new CorsConfiguration();
	     configuration.setAllowedOriginPatterns(Arrays.asList("*"));
	     configuration.setAllowedMethods(Arrays.asList("*"));
		 configuration.setAllowedHeaders(Arrays.asList("*"));
	     configuration.setAllowCredentials(true);
	     UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	     source.registerCorsConfiguration("/**", configuration);

		return source;
	}

	/*@Bean
	protected CorsConfigurationSource corsConfigurationSource() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}*/

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().authorizeRequests().anyRequest().permitAll().and().csrf().disable();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.GET, "/solicitudes/actuator");
	}
}
