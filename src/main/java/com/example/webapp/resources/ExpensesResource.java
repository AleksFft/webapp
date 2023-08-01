package com.example.webapp.resources;

import com.example.webapp.dto.ExpensesDto;
import com.example.webapp.services.ExpensesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/expenses")
@RequiredArgsConstructor
public class ExpensesResource {

    private final ExpensesService service;

    @GetMapping("/expenses")
    public ModelAndView getCompanies() {
        ModelAndView modelAndView = new ModelAndView("expenses");
        modelAndView.addObject("expenses", service.findAll());
        return modelAndView;
    }

    @GetMapping("/save_expenses")
    public ModelAndView saveCompany() {
        ModelAndView modelAndView = new ModelAndView("save_expenses");
        ExpensesDto dto = new ExpensesDto();
        modelAndView.addObject("expenses", dto);
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute ExpensesDto dto) {
        service.save(dto);
        return "redirect: expenses/expenses";
    }

    @PostMapping(value = "/update/{name}/{current_amount}/{new_amount}")
    public void update(@PathVariable("name") String name,
                       @PathVariable("current_amount") Long currentAmount,
                       @PathVariable("new_amount") Long new_amount) {
        service.update(name, currentAmount, new_amount);
    }

    @GetMapping("/updateForm")
    public ModelAndView updateForm(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView("save_expenses");
        modelAndView.addObject("expenses", service.findById(id));
        return modelAndView;
    }
}
