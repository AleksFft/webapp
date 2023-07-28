package com.example.webapp.services;

import com.example.webapp.dto.CompanyDto;
import com.example.webapp.mappers.CompanyMapper;
import com.example.webapp.model.Company;
import com.example.webapp.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository repository;

    public void save(CompanyDto companyDto) {
        Company company = CompanyMapper.INSTANCE.toEntity(companyDto);
        repository.save(company);
    }
}
