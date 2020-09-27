package com.furnitureapp.controller.stockcontrol;

import com.furnitureapp.entity.stockcontrol.Product;
import com.furnitureapp.factory.stockcontrol.ProductFactory;
import com.furnitureapp.service.stockcontrol.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/Product")

public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @PostMapping ("/create")
    public Product create (@RequestBody Product product){
        Product newProduct = ProductFactory.createProduct(product.getName(),
                product.getPrice(), product.getLength(), product.getWidth(),
                product.getWeight(), product.getDescription(), product.getCategory());
        return productService.create(newProduct);
    }

    @GetMapping("/read {prodCode}")
    public Product read(@PathVariable Integer prodCode) {
        return productService.read(prodCode);

    }

    @PostMapping ("/update")
    public Product update (@RequestBody Product product){
        return productService.update(product);

    }

    @DeleteMapping ("/delete {prodCode}")
    public boolean delete(@PathVariable Integer prodCode) {
        return productService.delete(prodCode);

    }

    @GetMapping ("/list")
    public Set <Product> list() {
        return productService.list();
    }

}
