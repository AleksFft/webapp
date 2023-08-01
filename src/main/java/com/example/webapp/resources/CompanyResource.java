package com.example.webapp.resources;

import com.example.webapp.dto.CompanyDto;
import com.example.webapp.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyResource {

    private final CompanyService service;

    @GetMapping("/companies")
    public ModelAndView getCompanies() {
        ModelAndView modelAndView = new ModelAndView("companies");
        modelAndView.addObject("companies", service.findAll());
        return modelAndView;
    }

    @GetMapping("/save_company")
    public ModelAndView saveCompany() {
        ModelAndView modelAndView = new ModelAndView("save_company");
        CompanyDto companyDto = new CompanyDto();
        modelAndView.addObject("company", companyDto);
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute CompanyDto companyDto) {
        service.save(companyDto);
        return "redirect: company/companies";
    }
}
