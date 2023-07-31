package com.example.webapp.resources;

import com.example.webapp.dto.ExpensesDto;
import com.example.webapp.services.ExpensesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expenses")
@RequiredArgsConstructor
public class ExpensesResource {

    private final ExpensesService service;

    @PostMapping(value = "/save")
    public void save(@RequestBody ExpensesDto dto) {
        service.save(dto);
    }

    @PostMapping(value = "/update/{name}/{current_amount}/{new_amount}")
    public void update(@PathVariable("name") String name,
                       @PathVariable("current_amount") Long currentAmount,
                       @PathVariable("new_amount") Long new_amount) {
        service.update(name, currentAmount, new_amount);
    }
}
