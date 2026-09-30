package com.tomholmes.product.jobsearch.ws.htmx;

import com.tomholmes.product.jobsearch.model.ApplicationEntity;
import com.tomholmes.product.jobsearch.model.CompanyEntity;
import com.tomholmes.product.jobsearch.service.ApplicationService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    // 1. Renders the full main page initially for companies
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

    // 2. Fetch a Single Row (Used for standard display & canceling an edit)
    @GetMapping("/{id}")
    public String getRow(@PathVariable Long id, Model model) {
        ApplicationEntity applicationEntity = applicationService.getById(id);
        model.addAttribute("app", applicationEntity);
        return "fragments/applications_ee :: app-row";
    }

    // 3. Swap Row into Edit Mode
    @GetMapping("/{id}/edit")
    public String editRow(@PathVariable Long id, Model model) {
        ApplicationEntity applicationEntity = applicationService.getById(id);
        model.addAttribute("app", applicationEntity);
        return "fragments/applications_ee :: app-edit-row";
    }

}
