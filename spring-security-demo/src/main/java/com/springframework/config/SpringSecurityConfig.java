package com.springframework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		/* default behaviour */
		/*
		 * http.authorizeHttpRequests((request) -> request.anyRequest().authenticated())
		 * .formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults());
		 */

		/* customized behaviour */
		http.authorizeHttpRequests(
				(request) -> request
							.requestMatchers("/myAccount", "/myBalance","/myLoans","/myCards").authenticated()
							.requestMatchers("/notices","/contact").permitAll())
							
				.formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults());

		return http.build();
	}

}
