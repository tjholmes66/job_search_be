package com.tomholmes.product.jobsearch.ws.htmx;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String showDashboard(Model model, @AuthenticationPrincipal OidcUser principal) {
        if (principal != null) {
            // Option A: Extract standard claims via explicit helper methods
            model.addAttribute("name", principal.getFullName());
            model.addAttribute("email", principal.getEmail());

            // Option B: Extract custom claims directly using keys from Keycloak token
            model.addAttribute("username", principal.getClaimAsString("preferred_username"));

            // Debug snippet: See all claims available to you in your console logs
            // System.out.println(principal.getClaims());
        }

        return "dashboard"; // Loads resources/templates/dashboard.html
    }
}


