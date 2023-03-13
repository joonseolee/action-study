package com.joonseolee.actionstudy.module;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    public List<Company> getCompanies() {
        return companyService.findAll();
    }

    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable long id) {
        return companyService.findById(id);
    }

    @PostMapping
    public Map<String, Long> addCompany(@RequestBody InsertCompany.Request request) {
        long id = companyService.addCompany(request);
        return Map.of("id", id);
    }
}
