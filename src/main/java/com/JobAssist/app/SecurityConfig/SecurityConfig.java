package com.JobAssist.app.SecurityConfig;


import lombok.RequiredArgsConstructor;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.JobAssist.app.service.CustomUserDetailsService;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private CustomUserDetailsService customUserDetailsService;
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    
    public SecurityConfig(CustomUserDetailsService customUserDetailsService,
			JwtAuthenticationFilter jwtAuthenticationFilter) {
		super();
		this.customUserDetailsService = customUserDetailsService;
		this.jwtAuthenticationFilter = jwtAuthenticationFilter;
	}

	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/JOBASSIST/public/**").permitAll()
                .requestMatchers("/JOBASSIST/admin/**").hasRole("ADMIN")
                .requestMatchers("/JOBASSIST/private/**").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
            )
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	 @Bean
	    public AuthenticationManager authManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {
	        return http.getSharedObject(AuthenticationManagerBuilder.class)
	            .userDetailsService(customUserDetailsService)
	            .passwordEncoder(passwordEncoder)
	            .and()
	            .build();
	    }
	 
	 @Bean
	    public CorsConfigurationSource corsConfigurationSource() {
	        CorsConfiguration configuration = new CorsConfiguration();
	        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
	        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
	        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
	        configuration.setAllowCredentials(true);  // Allow credentials (cookies, authorization headers, etc.)
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", configuration);
	        return source;
	    }
	 
	 @Bean
	    public CorsFilter  corsFilter() {
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        CorsConfiguration config = new CorsConfiguration();
	        config.setAllowCredentials(true);
	        config.addAllowedOriginPattern("*"); // Allow all origins
	        config.addAllowedHeader("*");       // Allow all headers
	        config.addAllowedMethod("*");       // Allow all HTTP methods
	        source.registerCorsConfiguration("/**", config);
	        return new CorsFilter(source);
	    }
}

