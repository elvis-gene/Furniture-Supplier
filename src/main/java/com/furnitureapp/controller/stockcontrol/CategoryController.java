package com.furnitureapp.controller.stockcontrol;

import com.furnitureapp.entity.stockcontrol.Category;
import com.furnitureapp.service.stockcontrol.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/Category")

public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @PostMapping("/create")
   public Category create(@RequestBody Category category){
       return categoryService.create(category);
    }

    @GetMapping("/read/{catCode}")
    public Category read (@PathVariable Integer catCode ){
        return categoryService.read(catCode);
    }

    @PostMapping ("/update")
    public Category update (@RequestBody Category category) {
        return categoryService.update(category);
    }

    @DeleteMapping ("/delete/{catCode}")
    public boolean delete(@PathVariable Integer catCode) {
        return categoryService.delete(catCode);

    }

    @GetMapping ("/list")
    public Set<Category> list() {
        return categoryService.list();
    }

}
