package com.joonseolee.actionstudy.module;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Company findById(long id) {
        return companyRepository.findById(id).orElse(null);
    }

    public long addCompany(InsertCompany.Request request) {
        var company = new Company(request.getName());
        return companyRepository.save(company).getId();
    }
}
