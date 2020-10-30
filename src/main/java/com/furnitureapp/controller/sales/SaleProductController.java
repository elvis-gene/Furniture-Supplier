package com.furnitureapp.controller.sales;

import com.furnitureapp.entity.sales.SaleProduct;
import com.furnitureapp.entity.sales.SaleProductCode;
import com.furnitureapp.service.sales.impl.SaleProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/sale_product")
public class SaleProductController {

    @Autowired
    private SaleProductServiceImpl saleProductService;

    @PostMapping("/create")
    public SaleProduct create(@RequestBody SaleProduct saleProduct){
        return saleProductService.create(saleProduct);
    }

    @GetMapping("/read/{id}")
    public SaleProduct read(@PathVariable SaleProductCode id){
        return saleProductService.read(id);
    }

    @PostMapping("/update")
    public SaleProduct update(@RequestBody SaleProduct saleProduct){
        return saleProductService.update(saleProduct);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable SaleProductCode id){
        return saleProductService.delete(id);
    }

    @GetMapping("/all")
    public Set<SaleProduct> getAll(){
        return saleProductService.list();
    }

}
