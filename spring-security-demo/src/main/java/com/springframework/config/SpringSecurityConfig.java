package com.springframework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

		http.csrf((csrf) -> csrf.disable())
				.authorizeHttpRequests(
						(request) -> request.requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards")
								.authenticated().requestMatchers("/notices", "/contact", "/register").permitAll())

				.formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults());

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
