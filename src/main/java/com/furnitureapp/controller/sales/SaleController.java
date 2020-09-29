package com.furnitureapp.controller.sales;

import com.furnitureapp.entity.sales.Sale;
import com.furnitureapp.service.sales.impl.SaleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private SaleServiceImpl saleService;

    @PostMapping("/create")
    public Sale create(@RequestBody Sale sale){
        return saleService.create(sale);
    }

    @GetMapping("/read/{id}")
    public Sale read(@PathVariable Integer id){
        return saleService.read(id);
    }

    @PostMapping("/update")
    public Sale update(@RequestBody Sale sale){
        return saleService.update(sale);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Integer id){
        return saleService.delete(id);
    }

    @GetMapping("/all")
    public Set<Sale> getAll(){
        return saleService.list();
    }

    @GetMapping("/monthly_sales")
    public Set<Sale> monthlySales(){
        return saleService.monthlySales();
    }

    @GetMapping("/monthly_entry")
    public double monthlyEntry(){
        return saleService.monthlySalesAmount();
    }

}
