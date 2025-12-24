package com.example.asankawebapp.controller;

import com.example.asankawebapp.model.Expenses;
import com.example.asankawebapp.model.Sales;
import com.example.asankawebapp.model.Stocks;
import com.example.asankawebapp.service.ExpenseService;
import com.example.asankawebapp.service.SalesService;
import com.example.asankawebapp.service.StockService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    private SalesService salesService;
    private ExpenseService expenseService;
    private StockService stockService;

    HomeController(SalesService salesService, ExpenseService expenseService, StockService stockService){
        this.salesService = salesService;
        this.expenseService = expenseService;
        this.stockService = stockService;
    }

    @GetMapping("/dashboard")
    public String getDashboard(Model model){
        model.addAttribute("totalDailySales", salesService.totalDaily());
        model.addAttribute("totalMonthlySales", salesService.totalMonthly());
        model.addAttribute("totalYearlySales", salesService.totalYearly());

        model.addAttribute("totalDailyExpenses", expenseService.totalDaily());
        model.addAttribute("totalMonthlyExpenses", expenseService.totalMonthly());
        model.addAttribute("totalYearlyExpenses", expenseService.totalYearly());

        model.addAttribute("totalDailyStocks", stockService.totalDaily());
        model.addAttribute("totalMonthlyStocks", stockService.totalMonthly());
        model.addAttribute("totalYearlyStocks", stockService.totalYearly());
        return "index.html";
    }

    @GetMapping("/sales")
    public String getSales(Model model){
        model.addAttribute("sales", salesService.getAll());
        return "sales.html";
    }

    @PostMapping("/sales")
    public String addSales(@ModelAttribute Sales sale){
        salesService.addSale(sale);
        return "sales.html";
    }

    @GetMapping("/expenses")
    public String getExpenses(Model model){
        model.addAttribute("expenses", expenseService.getAll());
        return "expenses.html";
    }

    @PostMapping("/expenses")
    public String addSales(@ModelAttribute Expenses expense){
        expenseService.add(expense);
        return "expense.html";
    }

    @GetMapping("/inventory")
    public String getInventory(Model model){
        model.addAttribute("stocks", stockService.getAll());
        return "inventory.html";
    }

    @PostMapping("/inventory")
    public String addInventory(@ModelAttribute Stocks stock){
        stockService.add(stock);
        return "inventory.html";
    }
}
