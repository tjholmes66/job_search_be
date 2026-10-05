package com.tomholmes.product.jobsearch.ws.htmx;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tomholmes.product.jobsearch.model.CompanyEntity;
import com.tomholmes.product.jobsearch.model.CompanyNoteEntity;
import com.tomholmes.product.jobsearch.repository.CompanyNoteRepository;
import com.tomholmes.product.jobsearch.service.CompanyService;

@Controller
@RequestMapping("/company-notes")
public class HtmxCompanyNotesController {

    private final CompanyService companyService;
    private final CompanyNoteRepository companyNoteRepository;

    public HtmxCompanyNotesController(CompanyService companyService, CompanyNoteRepository companyNoteRepository) {
        this.companyService = companyService;
        this.companyNoteRepository = companyNoteRepository;
    }

    // 1. Renders the full main page initially for companies
    @GetMapping("/companies")
    public String index(Model model) {
        List<CompanyEntity> companies = companyService.getAllCompanies();
        model.addAttribute("companies", companies);
        return "fragments/company_notes_ee";
    }

    // 1. Render the full page with company data and notes
    @GetMapping("/{companyId}")
    public String getCompanyNotes(@PathVariable Long companyId, Model model) {
        CompanyEntity company = companyService.getById(companyId);
        model.addAttribute("company", company);
        model.addAttribute("companies", companyService.getAllCompanies());

        List<CompanyNoteEntity> notes = companyNoteRepository.findByCompanyId(companyId);
        model.addAttribute("notes", notes);

        return "fragments/company_notes_ee";
    }

    // 2. Return just the company data section (for HTMX refresh)
    @GetMapping("/{companyId}/data")
    public String getCompanyData(@PathVariable Long companyId, Model model) {
        CompanyEntity company = companyService.getById(companyId);
        model.addAttribute("company", company);
        return "fragments/company_notes_ee :: company-data";
    }

    // 3. Return just the notes list (for HTMX refresh)
    @GetMapping("/{companyId}/notes")
    public String getNotesList(@PathVariable Long companyId, Model model) {
        List<CompanyNoteEntity> notes = companyNoteRepository.findByCompanyId(companyId);
        model.addAttribute("notes", notes);
        return "fragments/company_notes_ee :: notes-list";
    }

    // 4. Add a new note
    @PostMapping("/{companyId}/notes")
    public String addNote(@PathVariable Long companyId, @ModelAttribute CompanyNoteEntity note, Model model) {
        CompanyEntity company = companyService.getById(companyId);
        note.setCompany(company);
        note.setNoteDate(LocalDateTime.now());
        note.setCreatedBy(1);
        note.setCreatedDate(LocalDateTime.now());
        note.setUpdatedBy(1);
        note.setUpdatedDate(LocalDateTime.now());
        companyNoteRepository.save(note);

        List<CompanyNoteEntity> notes = companyNoteRepository.findByCompanyId(companyId);
        model.addAttribute("notes", notes);
        return "fragments/company_notes_ee :: notes-list";
    }
}
