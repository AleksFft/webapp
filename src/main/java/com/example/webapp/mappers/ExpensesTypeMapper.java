package com.example.webapp.mappers;

import com.example.webapp.dto.ExpensesTypeDto;
import com.example.webapp.model.ExpensesType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExpensesTypeMapper extends CommonMapper<ExpensesType, ExpensesTypeDto> {

    ExpensesTypeMapper INSTANCE = Mappers.getMapper(ExpensesTypeMapper.class);
}
