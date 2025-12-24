package com.example.asankawebapp.model;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Expenses {
    private int id;
    private String description;
    private LocalDate expenseDate;
    private double cost;

    Expenses(int id, String description, LocalDate expenseDate, double cost){
        this.id = id;
        this.description = description;
        this.expenseDate = expenseDate;
        this.cost = cost;
    }

    Expenses() {}

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public LocalDate getExpenseDate(){
        return expenseDate;
    }

    public void setExpenseDate(LocalDate expenseDate){
        this.expenseDate = expenseDate;
    }

    public double getCost(){
        return cost;
    }

    public void setCost(double cost){
        this.cost = cost;
    }
}
