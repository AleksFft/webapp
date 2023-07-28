package com.example.webapp.dto;

import com.example.webapp.model.PaymentType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpensesDto extends CommonDto {

    private PaymentType paymentType;
    private Long expensesTypeId;
    private Long companyId;
    private Long expensesAmount;
}
