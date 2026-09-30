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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping ("/companies")
public class HtmxCompanyController {

    private final CompanyService companyService;
    public HtmxCompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    // 1. Renders the full main page initially for companies
    @GetMapping("")
    public String index(Model model) {
        List<CompanyEntity> companies = companyService.getAllCompanies();
        model.addAttribute("companies", companies);
        return "fragments/companys_ee";
    }

    // 2. Fetch a Single Row (Used for standard display & canceling an edit)
    @GetMapping("/{id}")
    public String getRow(@PathVariable Long id, Model model) {
        CompanyEntity company = companyService.getById(id);
        model.addAttribute("company", company);
        return "fragments/companys_ee :: company-row";
    }

    // 3. Swap Row into Edit Mode
    @GetMapping("/{id}/edit")
    public String editRow(@PathVariable Long id, Model model) {
        CompanyEntity company = companyService.getById(id);
        model.addAttribute("company", company);
        return "fragments/companys_ee :: company-edit-row";
    }

    // 4. Save Inline Changes (PUT)
    @PutMapping("/{id}")
    public String saveRow(@PathVariable Long id, @ModelAttribute CompanyEntity updatedData, Model model) {
        CompanyEntity updatedCompany = companyService.updateCompany(updatedData);
        model.addAttribute("company", updatedCompany);
        return "fragments/companys_ee :: company-row";
    }

    // 5. Delete Row (Returns empty string to wipe DOM item out)
    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteRow(@PathVariable Long id) {
        companyService.deleteCompany(id);
        return "";
    }

    // 6. Open Inline Creation Form Row
    @GetMapping("/new")
    public String newRowForm() {
        return "fragments/companys_ee :: company-new-row";
    }

    // 7. Cancel Inline Creation Form Row
    @GetMapping("/cancel-new")
    public String cancelNewRow() {
        // Returns an empty row element matching the ID structure to clear it
        return "";
    }

    // 8. Handle Form Submission for New Record (POST)
    @PostMapping
    public String createCompany(@ModelAttribute CompanyEntity newCompany, Model model, HttpServletResponse response) {
        CompanyEntity saved = companyService.createCompany(newCompany);
        model.addAttribute("company", saved);

        // This handles appending the new row AND resetting the form inside #new-row-container out-of-band!
        response.setContentType("text/html");
        return "fragments/companys_ee :: company-row";
    }

}
