package com.example.asankawebapp.model;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Stocks {
    private int id;
    private String productName;
    private LocalDate stockDate;
    private int quantity;

    Stocks(int id, String productName, LocalDate stockDate, int quantity){
        this.id = id;
        this.productName = productName;
        this.stockDate = stockDate;
        this.quantity = quantity;
    }

    Stocks(){}

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getProductName(){
        return productName;
    }

    public void setProductName(String productName){
        this.productName = productName;
    }

    public LocalDate getStockDate(){
        return stockDate;
    }

    public void setStockDate(LocalDate stockDate){
        this.stockDate = stockDate;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}
