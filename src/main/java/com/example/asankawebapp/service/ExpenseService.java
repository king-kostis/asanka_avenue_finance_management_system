package com.example.asankawebapp.service;

import com.example.asankawebapp.model.Expenses;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {
    private static List<Expenses> expenses = new ArrayList<>();

    public List<Expenses> getAll(){
        return expenses;
    }

    public void add(Expenses expense){
        expenses.add(expense);


        int saleId = expenses.indexOf(expense);
        expenses.get(saleId).setId(saleId);
    }

    public void delete(int expenseId){
        expenses.remove(expenseId);
    }

    public double totalDaily(){
        double total = 0;
        for(int i = 0; i < expenses.size(); i++){
            LocalDate currentDate = LocalDate.now();
            LocalDate expenseDate = expenses.get(i).getExpenseDate();

            if(currentDate.equals(expenseDate)) {
                double price = expenses.get(i).getCost();
                total += price;
            }
        }
        return total;
    }

    public double totalMonthly(){
        double total = 0;
        for(int i = 0; i < expenses.size(); i++){
            LocalDate currentDate = LocalDate.now();
            LocalDate expenseDate = expenses.get(i).getExpenseDate();

            long dateInterval = ChronoUnit.DAYS.between(currentDate, expenseDate);

            if(dateInterval >= 30) {
                double price = expenses.get(i).getCost();
                total += price;
            }
        }
        return total;
    }

    public double totalYearly(){
        double total = 0;
        for(int i = 0; i < expenses.size(); i++){
            LocalDate currentDate = LocalDate.now();
            LocalDate expenseDate = expenses.get(i).getExpenseDate();

            long dateInterval = ChronoUnit.DAYS.between(currentDate, expenseDate);

            if(dateInterval >= 365) {
                double price = expenses.get(i).getCost();
                total += price;
            }
        }
        return total;
    }
}
