package com.example.asankawebapp.service;

import com.example.asankawebapp.model.Sales;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class SalesService {
    private static List<Sales> sales = new ArrayList<>();

    public List<Sales> getAll(){
        return sales;
    }

    public void addSale(Sales sale){
        sale.setDateOfSale(LocalDate.now());
        sales.add(sale);

        int saleId = sales.indexOf(sale);
        sales.get(saleId).setId(saleId);
    }

    public void deleteSale(int saleId){
        sales.remove(saleId);
    }

    public double totalDaily(){
        double total = 0;
        for(int i = 0; i < sales.size(); i++){
            LocalDate currentDate = LocalDate.now();
            LocalDate salesDate = sales.get(i).getDateOfSale();

            if(currentDate.equals(salesDate)) {
                double price = sales.get(i).getPrice();
                total += price;
            }
        }
        return total;
    }

    public double totalMonthly(){
        double total = 0;
        for(int i = 0; i < sales.size(); i++){
            LocalDate currentDate = LocalDate.now();
            LocalDate saleDate = sales.get(i).getDateOfSale();

            long dateInterval = ChronoUnit.DAYS.between(currentDate, saleDate);

            if(dateInterval >= 30) {
                double price = sales.get(i).getPrice();
                total += price;
            }
        }
        return total;
    }

    public double totalYearly(){
        double total = 0;
        for(int i = 0; i < sales.size(); i++){
            LocalDate currentDate = LocalDate.now();
            LocalDate saleDate = sales.get(i).getDateOfSale();

            long dateInterval = ChronoUnit.DAYS.between(currentDate, saleDate);

            if(dateInterval >= 365) {
                double price = sales.get(i).getPrice();
                total += price;
            }
        }
        return total;
    }
}
