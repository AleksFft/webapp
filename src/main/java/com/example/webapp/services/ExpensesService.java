package com.example.webapp.services;

import com.example.webapp.repository.ExpensesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExpensesService {

    private final ExpensesRepository expensesRepository;
}
