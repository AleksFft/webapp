package com.example.webapp.resources;

import com.example.webapp.dto.CompanyDto;
import com.example.webapp.dto.ExpensesTypeDto;
import com.example.webapp.model.ExpensesType;
import com.example.webapp.services.ExpensesTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/expenses_type")
@RequiredArgsConstructor
public class ExpensesTypeResource {

    private final ExpensesTypeService service;

    @GetMapping("/expenses_type")
    public ModelAndView getCompanies() {
        ModelAndView modelAndView = new ModelAndView("expenses_type");
        modelAndView.addObject("expenses_type", service.findAll());
        return modelAndView;
    }

    @GetMapping("/save_expenses_type")
    public ModelAndView saveCompany() {
        ModelAndView modelAndView = new ModelAndView("save_expenses_type");
        ExpensesTypeDto dto = new ExpensesTypeDto();
        modelAndView.addObject("expenses_type", dto);
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute ExpensesTypeDto dto) {
        service.save(dto);
        return "redirect: expenses_type/expenses_type";
    }
}
