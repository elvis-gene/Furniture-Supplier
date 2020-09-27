package com.furnitureapp.controller.stockcontrol;

import com.furnitureapp.entity.stockcontrol.Stock;
import com.furnitureapp.service.stockcontrol.impl.StockServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockServiceImpl stockService;

    @PostMapping("/create")
    public Stock create(@RequestBody Stock stock){
        return stockService.create(stock);
    }

    @GetMapping("/read/{id}")
    public Stock read(@PathVariable Integer id){
        return stockService.read(id);
    }

    @PostMapping("/update")
    public Stock update(@RequestBody Stock stock){
        return stockService.update(stock);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Integer id){
        return stockService.delete(id);
    }

    @GetMapping("/all")
    public Set<Stock> getAll(){
        return stockService.list();
    }

}
