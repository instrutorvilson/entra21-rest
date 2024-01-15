package com.authenticacao.authenticacao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {
   
   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	   return http
			  .csrf(csrf -> csrf.disable())
			  .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			  .authorizeHttpRequests(authorize -> authorize
					  .requestMatchers(HttpMethod.GET,"/contatos").permitAll()
					  .requestMatchers(HttpMethod.POST,"auth/register").permitAll()
					  .anyRequest().authenticated()
					 )
			  .build();
   }
}
