package com.tomholmes.product.jobsearch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 1. Configure URL authorization rules
                .authorizeHttpRequests(auth -> auth
                        // Allow public access explicitly to your static callback file
                        // 1. Permit the root path and index.html explicitly
                        .requestMatchers("/", "/static/**","/index.html").permitAll()

                        // 2. Permit common static folders (css, js, images, etc.)
                        .requestMatchers("/css/**", "/js/**", "/images/**", "/favicon.ico").permitAll()
                        .requestMatchers("/callback.html", "/resources/static/callback.html").permitAll()
                        .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()

                        // Require authentication for everything else (APIs, endpoints, etc.)
                        .anyRequest().authenticated()
                )
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/") // Prevents Spring from auto-redirecting to /login
                        .defaultSuccessUrl("/callback.html", true)
                )
                // Explicitly configures CSRF protection to use a cookie readable by JavaScript
                .csrf(csrf -> csrf
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                        .csrfTokenRequestHandler(new CsrfTokenRequestAttributeHandler())
                );

        return http.build();
    }

}
