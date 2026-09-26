package com.tomholmes.product.jobsearch.ws.htmx;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class HtmxDashboardController {

    @GetMapping("/dashboard")
    public String showDashboard(Model model, @AuthenticationPrincipal OidcUser principal) {
        if (principal != null) {
            model.addAttribute("name", principal.getFullName());
            model.addAttribute("email", principal.getEmail());
            model.addAttribute("username", principal.getClaimAsString("preferred_username"));
            model.addAttribute("roles", principal.getAuthorities());
        }
        return "dashboard";
    }

    // 2. HTMX endpoint filtering list options by Granted Authorities
    @GetMapping("/dashboard/menu")
    public String getSidebarMenu(Model model, @AuthenticationPrincipal OidcUser principal) {
        Map<String, List<Map<String, String>>> menuItems = new LinkedHashMap<>();

        if (principal != null) {
            // Map granted authorities to clean string tokens for simple list contains matching
            Set<String> authorities = principal.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toSet());

            // Only show User Management to Keycloak Admin Group mappings
            if (authorities.contains("ROLE_ADMINS")) {
                List<Map<String, String>> subMenuItems = new ArrayList<>();
                subMenuItems.add(Map.of("name", "Company Management", "url", "/companies"));
                subMenuItems.add(Map.of("name", "User Management", "url", "/users"));
                menuItems.put("Admin Menu", subMenuItems);
            }

            // Only show Reporting Suite to Moderators or Admins
            if (authorities.contains("ROLE_MODERATORS") || authorities.contains("ROLE_ADMINS")) {
                List<Map<String, String>> subMenuItems = new ArrayList<>();
                subMenuItems.add(Map.of("name", "Reporting Suite", "url", "/reports"));
                menuItems.put("Moderator Menu", subMenuItems);
            }

            // Only show Reporting Suite to Moderators or Admins or Users
            if (authorities.contains("ROLE_USERS") || authorities.contains("ROLE_ADMINS")) {
                List<Map<String, String>> subMenuItems = new ArrayList<>();
                subMenuItems.add(Map.of("name", "System Settings", "url", "/settings"));
                subMenuItems.add(Map.of("name", "List Application", "url", "/"));
                menuItems.put("User Menu", subMenuItems);
            }
        }

        // Add basic links available to all authenticated users
        // menuItems.add(Map.of("name", "Overview Monitor", "url", "/dashboard/overview"));
        // Always available settings view layout
        //menuItems.add(Map.of("name", "System Settings", "url", "/settings"));
        //menuItems.add(Map.of("name", "List Application", "url", "/"));

        model.addAttribute("menuItems", menuItems);
        return "fragments/menu";
    }
}
