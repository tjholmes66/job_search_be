package com.tomholmes.product.jobsearch.utils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.oidc.OidcIdToken; // Changed import

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Change type from Jwt to OidcIdToken
public class KeycloakRoleConverter implements Converter<OidcIdToken, Collection<GrantedAuthority>> {

    @Override
    public Collection<GrantedAuthority> convert(OidcIdToken idToken) {
        // OidcIdToken exposes getClaim() naturally
        Map<String, Object> realmAccess = idToken.getClaim("realm_access");

        if (realmAccess == null || realmAccess.isEmpty()) {
            return Collections.emptyList();
        }

        @SuppressWarnings("unchecked")
        List<String> roles = (List<String>) realmAccess.get("roles");

        if (roles == null) {
            return Collections.emptyList();
        }

        return roles.stream()
                .map(roleName -> "ROLE_" + roleName.toUpperCase())
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
