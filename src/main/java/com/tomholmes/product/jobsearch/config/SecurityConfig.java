package com.tomholmes.product.jobsearch.config;

import com.tomholmes.product.jobsearch.utils.KeycloakRoleConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
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
                        // Allow public access to landing pages and static assets
                        .requestMatchers("/", "/index.html", "/static/**").permitAll()
                        .requestMatchers("/css/**", "/js/**", "/images/**", "/favicon.ico").permitAll()

                        // ONLY protect the Controller endpoint.
                        // Do NOT include "/dashboard.html" here if it lives in /templates/
                        .requestMatchers("/dashboard").authenticated()

                        // Require authentication for everything else (APIs, endpoints, etc.)
                        .anyRequest().authenticated()
                )
                // 2. Configure OAuth2 Login
                .oauth2Login(oauth2 -> oauth2
                        // If OAuth2 fails, seamlessly send them back to your index page with a message
                        .failureUrl("/index.html?error=true")
                        // When login succeeds, hit your backend controller route
                        .defaultSuccessUrl("/dashboard", true)
                )
                // 3. Configure CSRF protection
                .csrf(csrf -> csrf
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                        .csrfTokenRequestHandler(new CsrfTokenRequestAttributeHandler())
                );

        return http.build();
    }

    private OAuth2UserService<OidcUserRequest, OidcUser> oidcUserService() {
        OidcUserService delegate = new OidcUserService();
        KeycloakRoleConverter roleConverter = new KeycloakRoleConverter();

        return userRequest -> {
            OidcUser oidcUser = delegate.loadUser(userRequest);
            // Parse roles out of the ID Token
            var mappedAuthorities = roleConverter.convert(userRequest.getIdToken());

            return new DefaultOidcUser(mappedAuthorities, oidcUser.getIdToken(), oidcUser.getUserInfo());
        };
    }

}
