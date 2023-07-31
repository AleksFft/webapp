package com.example.webapp.mappers;

import com.example.webapp.dto.ExpensesDto;
import com.example.webapp.model.Expenses;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExpensesMapper extends CommonMapper<Expenses, ExpensesDto> {

    ExpensesMapper INSTANCE = Mappers.getMapper(ExpensesMapper.class);

    @Override
    @Mapping(target = "company", ignore = true)
    @Mapping(target = "expensesType", ignore = true)
    Expenses toEntity(ExpensesDto dto);
}
