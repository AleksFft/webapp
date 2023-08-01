package com.example.webapp.services;

import com.example.webapp.dto.ExpensesDto;
import com.example.webapp.mappers.ExpensesMapper;
import com.example.webapp.model.Company;
import com.example.webapp.model.Expenses;
import com.example.webapp.model.ExpensesType;
import com.example.webapp.repository.ExpensesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpensesService {

    private static final String ERROR_MESSAGE = "amount bigger than MDS";

    private final ExpensesRepository repository;
    private final ExpensesTypeService expensesTypeService;
    private final CompanyService companyService;

    public List<ExpensesDto> findAll() {
        return repository.findAll().stream()
                .map(ExpensesMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    public void save(ExpensesDto dto) {
        ExpensesType expensesType = expensesTypeService.findByName(dto.getExpensesName());
        if (dto.getExpensesAmount() < expensesType.getMds()) {
            Expenses entity = ExpensesMapper.INSTANCE.toEntity(dto);
            entity.setExpensesType(expensesType);
            repository.save(entity);
        } else
            throw new RuntimeException(ERROR_MESSAGE);
    }

    public void update(String name, Long currentAmount, Long newAmount) {
        Expenses expenses = repository.findExpensesByNameAndAmount(name, currentAmount);
        if (isValidToUpdate(name, newAmount)) {
            expenses.setExpensesAmount(newAmount);
        } else
            throw new RuntimeException(ERROR_MESSAGE);
    }

    private boolean isValidToUpdate(String expensesName, Long newAmount) {
        String[] sumAmountAndMds = repository.sumAmountAndMds(expensesName).split(",");
        return Long.parseLong(sumAmountAndMds[0]) > Long.parseLong(sumAmountAndMds[1]) + newAmount;
    }

    public ExpensesDto findById(Long id) {
        return ExpensesMapper.INSTANCE.toDto(repository.findById(id).orElseThrow());
    }
}
