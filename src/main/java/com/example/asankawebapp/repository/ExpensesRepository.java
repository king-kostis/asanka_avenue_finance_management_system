package com.example.asankawebapp.repository;

import com.example.asankawebapp.model.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpensesRepository extends JpaRepository<Expenses, Integer>{
}
