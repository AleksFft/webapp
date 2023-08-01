package com.example.webapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "EXPENSES")
@EqualsAndHashCode(callSuper=false)
public class Expenses extends CommonEntity{

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "PAYMENT_TYPE")
    private PaymentType paymentType;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EXPENSES_TYPE_ID")
    private ExpensesType expensesType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID")
    private Company company;

    @Column(name = "EXPENSES_AMOUNT")
    private Long expensesAmount;

    @Nullable
    public Company getCompany() {
        return company;
    }
}
