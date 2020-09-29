package com.furnitureapp.controller.sales;

import com.furnitureapp.entity.sales.Sale;
import com.furnitureapp.entity.sales.SaleProduct;
import com.furnitureapp.entity.stockcontrol.Product;
import com.furnitureapp.factory.sales.SaleProductFactory;
import com.furnitureapp.service.sales.impl.SaleProductServiceImpl;
import com.furnitureapp.service.sales.impl.SaleServiceImpl;
import com.furnitureapp.service.stockcontrol.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/sale_product")
public class SaleProductController {

    @Autowired
    private SaleProductServiceImpl saleProductService;
    @Autowired
    private SaleServiceImpl saleService;
    @Autowired
    private ProductServiceImpl productService;

    @PostMapping("/create")
    public SaleProduct create(@RequestBody SaleProduct saleProduct){

        Sale sale = saleService.read(saleProduct.getSaleCode());
        Product product = productService.read(saleProduct.getProdCode());

        if (sale != null && product != null)
            return saleProductService.create(saleProduct);
        else
            return SaleProductFactory.createSaleProduct(null, 0);

    }

    @GetMapping("/read/{sId}/{pId}")
    public SaleProduct read(@PathVariable Integer sId, @PathVariable Integer pId){
        return saleProductService.read(sId,pId);
    }

    @PostMapping("/update")
    public SaleProduct update(@RequestBody SaleProduct saleProduct){
        return saleProductService.update(saleProduct);
    }

    @DeleteMapping("/delete/{sId}/{pId}")
    public boolean delete(@PathVariable Integer sId, @PathVariable Integer pId){
        return saleProductService.delete(sId, pId);
    }

    @GetMapping("/all")
    public Set<SaleProduct> getAll(){
        return saleProductService.list();
    }

}
