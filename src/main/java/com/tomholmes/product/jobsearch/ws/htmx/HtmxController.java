package com.tomholmes.product.jobsearch.ws.htmx;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HtmxController {

    // Mock data source
    private final List<String> users = List.of("Alice Smith", "Bob Jones", "Charlie Brown", "Diana Prince");

    // 1. Renders the full main page initially
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", users);
        return "index";
    }

    // 2. Renders ONLY the user-list fragment for an htmx request
    @GetMapping("/users/search")
    public String searchUsers(@RequestParam(value = "q", required = false, defaultValue = "") String query, Model model) {
        List<String> filteredUsers = users.stream()
                .filter(user -> user.toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());

        model.addAttribute("users", filteredUsers);

        // Returns "templateName :: fragmentName"
        return "index :: user-list";
    }
}
