package com.example.webapp.resources;

import com.example.webapp.dto.CompanyDto;
import com.example.webapp.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyResource {

    private final CompanyService service;

    @PostMapping(value = "/save")
    public void save(@RequestBody CompanyDto companyDto) {
        service.save(companyDto);
    }
}
