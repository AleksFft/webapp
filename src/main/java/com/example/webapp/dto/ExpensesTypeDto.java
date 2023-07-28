package com.example.webapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpensesTypeDto extends CommonDto {
    private String expensesName;
    private Long mds;
}
