package com.example.asankawebapp.service;

import com.example.asankawebapp.model.Sales;
import com.example.asankawebapp.repository.SalesRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class SalesService {

    private static final LocalDate currentDate = LocalDate.now();
    private final SalesRepository salesRepository;

    public SalesService(SalesRepository salesRepository){
        this.salesRepository = salesRepository;
    }

    public List<Sales> getAll(){
        List<Sales> sales = new ArrayList<>();
        sales = salesRepository.findAll();
        return sales;
    }

    public void addSale(Sales sale) {
        salesRepository.save(sale);
    }

    public void delete(int saleId){
        salesRepository.deleteById(saleId);
    }

    //Calculate total sales for the day
    public double totalDaily(){
        double total = 0;
        for(int i = 0; i < getAll().size(); i++){
            LocalDate salesDate = getAll().get(i).getDateOfSale(); //Get sale date of object from list

            //Checks if date is current date to validate for calculation
            if(currentDate.equals(salesDate)) {
                double price = getAll().get(i).getPrice();
                total += price;
            }
        }
        return total;
    }

    //Calculate total sales for the month
    public double totalMonthly(){
        double total = 0;
        for(int i = 0; i < getAll().size(); i++){
            LocalDate saleDate = getAll().get(i).getDateOfSale();

            //Checks if the date sold is within a month from current date for monthly calculation
            long dateInterval = ChronoUnit.DAYS.between(currentDate, saleDate);
            if(dateInterval >= 30 && dateInterval < 32) {
                double price = getAll().get(i).getPrice();
                total += price;
            }
        }
        return total;
    }

    //Calculate total sales for the year
    public double totalYearly(){
        double total = 0;
        for(int i = 0; i < getAll().size(); i++){
            LocalDate saleDate = getAll().get(i).getDateOfSale();

            //Checks if the expense date is within a year from current date for yearly calculation
            long dateInterval = ChronoUnit.DAYS.between(currentDate, saleDate);
            if(dateInterval >= 365 && dateInterval < 367) {
                double price = getAll().get(i).getPrice();
                total += price;
            }
        }
        return total;
    }
}
