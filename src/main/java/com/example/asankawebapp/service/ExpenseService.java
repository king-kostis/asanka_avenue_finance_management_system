package com.example.asankawebapp.service;

import com.example.asankawebapp.model.Expenses;
import com.example.asankawebapp.repository.ExpensesRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {

    private final ExpensesRepository expensesRepository;
    private static final LocalDate currentDate = LocalDate.now();

    public ExpenseService(ExpensesRepository expensesRepository){
        this.expensesRepository = expensesRepository;
    }

    public List<Expenses> getAll(){
        List<Expenses> expenses = new ArrayList<>();
        expenses = expensesRepository.findAll();
        return expenses;
    }

    public void add(Expenses expense){
        expensesRepository.save(expense);
    }

    public void delete(int expenseId){
        expensesRepository.deleteById(expenseId);
    }

    //Calculate total expenses for the day
    public double totalDaily(){
        double total = 0;
        for(int i = 0; i < getAll().size(); i++){
            LocalDate expenseDate = getAll().get(i).getExpenseDate(); //Get expense date of object from list

            //Checks if date is current date to validate for calculation
            if(currentDate.equals(expenseDate)) {
                double price = getAll().get(i).getCost();
                total += price;
            }
        }
        return total;
    }

    //Calculate total expenses for the month
    public double totalMonthly(){
        double total = 0;
        for(int i = 0; i < getAll().size(); i++){
            LocalDate expenseDate = getAll().get(i).getExpenseDate();

            //Checks if the expense date is within a month from current date for monthly calculation
            long dateInterval = ChronoUnit.DAYS.between(currentDate, expenseDate);
            if(dateInterval >= 30 && dateInterval < 32) {
                double price = getAll().get(i).getCost();
                total += price;
            }
        }
        return total;
    }

    //Calculate total expenses for the year
    public double totalYearly(){
        double total = 0;
        for(int i = 0; i < getAll().size(); i++){
            LocalDate expenseDate = getAll().get(i).getExpenseDate();

            //Checks if the expense date is within a year from current date for yearly calculation
            long dateInterval = ChronoUnit.DAYS.between(currentDate, expenseDate);
            if(dateInterval >= 365 && dateInterval < 367) {
                double price = getAll().get(i).getCost();
                total += price;
            }
        }
        return total;
    }
}
