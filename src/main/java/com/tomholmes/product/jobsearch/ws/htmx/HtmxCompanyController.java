package com.tomholmes.product.jobsearch.ws.htmx;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HtmxCompanyController {

    // Mock data source for companies
    private final List<String> companies = List.of("Acme Corp", "Globex Corporation", "Initech", "Umbrella Corp");

    // 1. Renders the full main page initially for companies
    @GetMapping("/companies")
    public String index(Model model) {
        model.addAttribute("companies", companies);
        return "companies_ee";
    }

    // 2. Renders ONLY the company-list fragment for an htmx request
    @GetMapping("/companies/search")
    public String searchCompanies(@RequestParam(value = "q", required = false, defaultValue = "") String query, Model model) {
        List<String> filteredCompanies = companies.stream()
                .filter(company -> company.toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());

        model.addAttribute("companies", filteredCompanies);

        // Returns "templateName :: fragmentName"
        return "companies_ee :: company-list";
    }
}
