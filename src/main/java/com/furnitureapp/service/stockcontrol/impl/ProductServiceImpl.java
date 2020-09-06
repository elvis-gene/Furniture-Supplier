package com.furnitureapp.service.stockcontrol.impl;

import com.furnitureapp.entity.stockcontrol.Product;
import com.furnitureapp.repository.stockcontrol.ProductRepository;
import com.furnitureapp.repository.stockcontrol.impl.ProductRepositoryImpl;
import com.furnitureapp.service.stockcontrol.ProductService;

import java.util.Set;

public class ProductServiceImpl implements ProductService {

    private static ProductService productService = null;
    private ProductRepository productRepository;

    private ProductServiceImpl() {
        this.productRepository = ProductRepositoryImpl.getProductRepository();
    }

    public static ProductService getProductService(){
        if (productService == null)
            productService = new ProductServiceImpl();
        return productService;
    }

    @Override
    public Set<Product> list() {
        return this.productRepository.list();
    }

    @Override
    public Product create(Product product) {
        return this.productRepository.create(product);
    }

    @Override
    public Product read(Integer integer) {
        return this.productRepository.read(integer);
    }

    @Override
    public Product update(Product product) {
        return this.productRepository.update(product);
    }

    @Override
    public boolean delete(Integer integer) {
        return this.productRepository.delete(integer);
    }
}
