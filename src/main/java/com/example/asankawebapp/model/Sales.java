package com.example.asankawebapp.model;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Sales {
    private int id;
    private String itemName;
    private LocalDate dateOfSale;
    private double price;

    Sales(int id, String itemName, LocalDate dateOfSale, double price){
        this.id = id;
        this.itemName = itemName;
        this.dateOfSale = dateOfSale;
        this.price = price;
    }

    Sales() {}

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getItemName(){
        return itemName;
    }

    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    public LocalDate getDateOfSale(){
        return dateOfSale;
    }

    public void setDateOfSale(LocalDate dateOfSale){
        this.dateOfSale = dateOfSale;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }
}
