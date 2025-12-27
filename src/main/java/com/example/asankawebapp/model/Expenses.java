package com.example.asankawebapp.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Entity
@Table(name="expenses")
public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="description")
    private String description;

    @Column(name="expense_date")
    private LocalDate expenseDate;

    @Column(name="cost")
    private double cost;

    public Expenses(int id, String description, LocalDate expenseDate, double cost){
        this.id = id;
        this.description = description;
        this.expenseDate = expenseDate;
        this.cost = cost;
    }

    public Expenses() {}

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


    @Override
    public String toString() {
        return "Expenses{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", expenseDate=" + expenseDate +
                ", cost=" + cost +
                '}';
    }
}
