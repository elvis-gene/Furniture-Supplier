package com.furnitureapp.controller.stockcontrol;

import com.furnitureapp.entity.stockcontrol.ProductCategory;
import com.furnitureapp.service.stockcontrol.impl.ProductCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/ProductCategory")

public class ProductCategoryController {

    @Autowired
    private ProductCategoryServiceImpl productCategoryService;

    @PostMapping("/create")
   public ProductCategory create(@RequestBody ProductCategory productCategory){
       return productCategoryService.create(productCategory);
    }

    @GetMapping("/read {catCode}")
    public ProductCategory read (@PathVariable Integer catCode ){
        return productCategoryService.read(catCode);
    }

    @PostMapping ("/update")
    public ProductCategory update (@RequestBody ProductCategory productCategory) {
        return productCategoryService.update(productCategory);
    }

    @DeleteMapping ("/delete {catCode}")
    public boolean delete(@PathVariable Integer catcode) {
        return productCategoryService.delete(catcode);

    }

    @GetMapping ("/list")
    public Set<ProductCategory> list() {
        return productCategoryService.list();
    }

}
