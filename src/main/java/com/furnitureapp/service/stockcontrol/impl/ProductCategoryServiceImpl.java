package com.furnitureapp.service.stockcontrol.impl;

import com.furnitureapp.entity.stockcontrol.ProductCategory;
import com.furnitureapp.repository.stockcontrol.ProductCategoryRepository;
import com.furnitureapp.service.stockcontrol.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.stream.Collectors;

@Service

public class ProductCategoryServiceImpl implements ProductCategoryService {

    private static ProductCategoryService categoryService = null;

    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public Set<ProductCategory> list() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public ProductCategory create(ProductCategory productCategory) {
        return this.repository.save(productCategory);
    }

    @Override
    public ProductCategory read(Integer integer) {
        return this.repository.findById(integer).orElseGet(null);
    }

    @Override
    public ProductCategory update(ProductCategory productCategory) {
        return this.repository.save(productCategory);
    }

    @Override
    public boolean delete(Integer integer) {
        this.repository.deleteById(integer);
        if (this.repository.existsById(integer)) return false;
        else return true;
    }
}
