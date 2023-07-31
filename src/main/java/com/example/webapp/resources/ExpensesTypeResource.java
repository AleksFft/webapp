package com.example.webapp.resources;

import com.example.webapp.dto.ExpensesTypeDto;
import com.example.webapp.model.ExpensesType;
import com.example.webapp.services.ExpensesTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expenses_type")
@RequiredArgsConstructor
public class ExpensesTypeResource {

    private final ExpensesTypeService service;

    @PostMapping(value = "/save")
    public void save(@RequestBody ExpensesTypeDto dto) {
        service.save(dto);
    }
}
