package com.example.webapp.services;

import com.example.webapp.dto.ExpensesTypeDto;
import com.example.webapp.mappers.ExpensesTypeMapper;
import com.example.webapp.model.ExpensesType;
import com.example.webapp.repository.ExpensesTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExpensesTypeService {

    private final ExpensesTypeRepository repository;

    public void save(ExpensesTypeDto dto) {
        ExpensesType entity = ExpensesTypeMapper.INSTANCE.toEntity(dto);
        repository.save(entity);
    }
}
