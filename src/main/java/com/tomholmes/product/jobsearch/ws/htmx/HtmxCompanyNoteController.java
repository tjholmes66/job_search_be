package com.tomholmes.product.jobsearch.ws.htmx;

import com.tomholmes.product.jobsearch.model.CompanyEntity;
import com.tomholmes.product.jobsearch.service.CompanyService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

public class HtmxCompanyNoteController {

    private final CompanyService companyService;
    public HtmxCompanyNoteController(CompanyService companyService) {
        this.companyService = companyService;
    }

    // 1. Renders the full main page initially for companies
    @GetMapping("/companies")
    public String index(Model model) {
        List<CompanyEntity> companies = companyService.getAllCompanies();
        model.addAttribute("companies", companies);
        return "fragments/companys_ee";
    }

    // 2. Fetch a Single Row (Used for standard display & canceling an edit)
    @GetMapping("/{id}")
    public String getRow(@PathVariable Long id, Model model) {
        //CompanyEntity company = companyService.getById(id);
        CompanyEntity company = companyService.
        model.addAttribute("company", company);
        return "companys_ee :: company-row";
    }
}
