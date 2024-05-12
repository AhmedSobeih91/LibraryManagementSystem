package com.LibraryManagementSystem.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class securityconfigure {

	@Bean
	SecurityFilterChain defultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(a -> {

			a.requestMatchers("/api/signup").permitAll();
			a.requestMatchers("/api/books/**", "/api/borrow/**", "/api/return/**").hasAnyRole("user", "libarian",
					"admin");
			a.requestMatchers("/api/patrons", "/api/patrons/**").hasAnyRole("libarian", "admin");
			a.requestMatchers("/api/**").hasRole("admin");
		});

		http.cors(AbstractHttpConfigurer::disable);
		http.csrf(AbstractHttpConfigurer::disable);
		http.headers(AbstractHttpConfigurer::disable);
		http.formLogin(Customizer.withDefaults());
		http.httpBasic(Customizer.withDefaults());
		return http.build();
	}

	@Bean
	PasswordEncoder password() {
		return NoOpPasswordEncoder.getInstance();
	}

}
