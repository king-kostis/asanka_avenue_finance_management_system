package com.example.asankawebapp.service;

import com.example.asankawebapp.model.Sales;
import com.example.asankawebapp.model.Stocks;
import com.example.asankawebapp.repository.StocksRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {
    private final StocksRepository stocksRepository;
    private static final LocalDate currentDate = LocalDate.now();

    public StockService(StocksRepository stocksRepository){
        this.stocksRepository = stocksRepository;
    }

    public List<Stocks> getAll(){
        List<Stocks> stocks = new ArrayList<>();
        stocks = stocksRepository.findAll();
        return stocks;
    }

    public void add(Stocks stock){
        stocksRepository.save(stock);
    }

    public void delete(int stockId){
        stocksRepository.deleteById(stockId);
    }

    //Calculate total stocks for the day
    public double totalDaily(){
        double total = 0;
        for(int i = 0; i < getAll().size(); i++){
            LocalDate stockDate = getAll().get(i).getStockDate(); //Get date stocked from list

            //Checks if date is current date to validate for calculation
            if(currentDate.equals(stockDate)) {
                int amount = getAll().get(i).getQuantity();
                total += amount;
            }
        }
        return total;
    }


    public double totalMonthly(){
        double total = 0;
        for(int i = 0; i < getAll().size(); i++){
            LocalDate stockDate = getAll().get(i).getStockDate();

            long dateInterval = ChronoUnit.DAYS.between(currentDate, stockDate);

            if(dateInterval >= 30) {
                int amount = getAll().get(i).getQuantity();
                total += amount;
            }
        }
        return total;
    }

    public double totalYearly(){
        double total = 0;
        for(int i = 0; i < getAll().size(); i++){
            LocalDate stockDate = getAll().get(i).getStockDate();

            long dateInterval = ChronoUnit.DAYS.between(currentDate, stockDate);

            if(dateInterval >= 365) {
                int amount = getAll().get(i).getQuantity();
                total += amount;
            }
        }
        return total;
    }
}
