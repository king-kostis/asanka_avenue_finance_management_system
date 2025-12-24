package com.example.asankawebapp.service;

import com.example.asankawebapp.model.Sales;
import com.example.asankawebapp.model.Stocks;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {
    private static List<Stocks> stocks = new ArrayList<>();

    public List<Stocks> getAll(){
        return stocks;
    }

    public void add(Stocks stock){
        stocks.add(stock);

        int stockId = stocks.indexOf(stock);
        stocks.get(stockId).setId(stockId);
    }

    public void delete(int stockId){
        stocks.remove(stockId);
    }

    public double totalDaily(){
        double total = 0;
        for(int i = 0; i < stocks.size(); i++){
            LocalDate currentDate = LocalDate.now();
            LocalDate stockDate = stocks.get(i).getStockDate();

            if(currentDate.equals(stockDate)) {
                int amount = stocks.get(i).getQuantity();
                total += amount;
            }
        }
        return total;
    }

    public double totalMonthly(){
        double total = 0;
        for(int i = 0; i < stocks.size(); i++){
            LocalDate currentDate = LocalDate.now();
            LocalDate stockDate = stocks.get(i).getStockDate();

            long dateInterval = ChronoUnit.DAYS.between(currentDate, stockDate);

            if(dateInterval >= 30) {
                int amount = stocks.get(i).getQuantity();
                total += amount;
            }
        }
        return total;
    }

    public double totalYearly(){
        double total = 0;
        for(int i = 0; i < stocks.size(); i++){
            LocalDate currentDate = LocalDate.now();
            LocalDate stockDate = stocks.get(i).getStockDate();

            long dateInterval = ChronoUnit.DAYS.between(currentDate, stockDate);

            if(dateInterval >= 365) {
                int amount = stocks.get(i).getQuantity();
                total += amount;
            }
        }
        return total;
    }
}
