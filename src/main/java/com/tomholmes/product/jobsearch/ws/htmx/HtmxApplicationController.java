package com.tomholmes.product.jobsearch.ws.htmx;

import com.tomholmes.product.jobsearch.model.ApplicationEntity;
import com.tomholmes.product.jobsearch.service.ApplicationService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app")
public class HtmxApplicationController {

    private ApplicationService applicationService;

    public HtmxApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/user")
    public String getUserDetails(Model model, @AuthenticationPrincipal OidcUser principal) {

        // initialize the list
        List<ApplicationEntity> list = new ArrayList<>();

        if (principal != null) {
            String username = principal.getPreferredUsername();
            model.addAttribute("username", username);
            list = applicationService.findByUsername(username);
        }

        model.addAttribute("apps", list);

        // Return a Thymeleaf HTML fragment for HTMX to swap into the DOM
        return "fragments/applications_ee";
    }

}
