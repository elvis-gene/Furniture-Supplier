package com.furnitureapp.controller.stockcontrol;

import com.furnitureapp.entity.stockcontrol.Category;
import com.furnitureapp.service.stockcontrol.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/ProductCategory")

public class CategoryController {

    @Autowired
    private CategoryServiceImpl productCategoryService;

    @PostMapping("/create")
   public Category create(@RequestBody Category category){
       return productCategoryService.create(category);
    }

    @GetMapping("/read {catCode}")
    public Category read (@PathVariable Integer catCode ){
        return productCategoryService.read(catCode);
    }

    @PostMapping ("/update")
    public Category update (@RequestBody Category category) {
        return productCategoryService.update(category);
    }

    @DeleteMapping ("/delete {catCode}")
    public boolean delete(@PathVariable Integer catcode) {
        return productCategoryService.delete(catcode);

    }

    @GetMapping ("/list")
    public Set<Category> list() {
        return productCategoryService.list();
    }

}
