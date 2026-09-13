package com.tomholmes.product.jobsearch.ws.htmx;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String showDashboard() {
        return "dashboard"; // This tells Spring to look for templates/dashboard.html
    }
}

