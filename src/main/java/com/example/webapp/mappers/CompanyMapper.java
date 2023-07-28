package com.example.webapp.mappers;

import com.example.webapp.dto.CompanyDto;
import com.example.webapp.model.Company;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CompanyMapper extends CommonMapper<Company, CompanyDto> {

    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);
}
