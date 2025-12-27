package com.example.asankawebapp.controller;

import com.example.asankawebapp.model.Expenses;
import com.example.asankawebapp.model.Sales;
import com.example.asankawebapp.model.Stocks;
import com.example.asankawebapp.service.ExpenseService;
import com.example.asankawebapp.service.SalesService;
import com.example.asankawebapp.service.StockService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("sale", new Sales());
        return "sales.html";
    }

    //Add sales record
    @PostMapping("/sales")
    public String addSales(@ModelAttribute("sale") Sales sale){
        salesService.addSale(sale);
        return "redirect:/sales";
    }

    //Delete sales record by id
    @PostMapping("/sales/delete/{id}")
    public String deleteSales(Model model, @PathVariable int id){
        expenseService.delete(id);
        model.addAttribute("sale", new Sales()); // for binding object to delete button
        return "redirect:/sales";
    }

    @GetMapping("/expenses")
    public String getExpenses(Model model){
        model.addAttribute("expenses", expenseService.getAll());
        model.addAttribute("expense", new Expenses());
        return "expenses.html";
    }

    //Add expense record
    @PostMapping("/expenses")
    public String addSales(@ModelAttribute("expense") Expenses expense){
        expenseService.add(expense);
        return "redirect:/expenses";
    }

    //Delete expense record by id
    @PostMapping("/expenses/delete/{id}")
    public String deleteExpense(Model model, @PathVariable int id){
        expenseService.delete(id);
        model.addAttribute("expense", new Expenses());
        return "redirect:/expenses";
    }

    @GetMapping("/inventory")
    public String getInventory(Model model){
        model.addAttribute("stocks", stockService.getAll());
        model.addAttribute("stock", new Stocks());
        return "inventory.html";
    }

    @PostMapping("/inventory")
    public String addInventory(@ModelAttribute("stock") Stocks stock){
        stockService.add(stock);
        return "redirect:/inventory";
    }

    @PostMapping("/inventory/delete/{id}")
    public String deleteInventory(Model model, @PathVariable int id){
        stockService.delete(id);
        model.addAttribute("stock", new Stocks());
        return "redirect:/inventory";
    }
}
