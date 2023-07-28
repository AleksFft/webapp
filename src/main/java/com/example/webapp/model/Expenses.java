package com.example.webapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "EXPENSES")
@EqualsAndHashCode(callSuper = false)
public class Expenses extends CommonEntity{

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "PAYMENT_TYPE")
    private PaymentType paymentType;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EXPENSES_TYPE_ID")
    private ExpensesType expensesType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "COMPANY_ID")
    private Company company;

    @Column(name = "EXPENSES_AMOUNT")
    private Long expensesAmount;
}
