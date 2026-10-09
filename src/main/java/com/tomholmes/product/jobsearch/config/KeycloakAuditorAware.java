package com.tomholmes.product.jobsearch.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.jwt.Jwt;

// Class is used to return the UserId from Keycloak

@Component
public class KeycloakAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) return Optional.empty();
        Object p = auth.getPrincipal();
        if (p instanceof OidcUser oidc) return Optional.of(oidc.getSubject());
        if (p instanceof Jwt jwt) return Optional.of(jwt.getSubject());
        return Optional.empty();
    }
}
