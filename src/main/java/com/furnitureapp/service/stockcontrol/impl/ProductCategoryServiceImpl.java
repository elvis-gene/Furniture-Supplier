package com.furnitureapp.service.stockcontrol.impl;

import com.furnitureapp.entity.stockcontrol.ProductCategory;
import com.furnitureapp.repository.stockcontrol.ProductCategoryRepository;
import com.furnitureapp.repository.stockcontrol.impl.ProductCategoryRepositoryImpl;
import com.furnitureapp.service.stockcontrol.ProductCategoryService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service

public class ProductCategoryServiceImpl implements ProductCategoryService {

    private static ProductCategoryService categoryService = null;
    private ProductCategoryRepository repository;

    private ProductCategoryServiceImpl() {
        this.repository = ProductCategoryRepositoryImpl.getProductCategoryRepository();
    }

    public static ProductCategoryService getCategoryService() {
        if (categoryService == null)
            categoryService = new ProductCategoryServiceImpl();
        return categoryService;
    }


    @Override
    public Set<ProductCategory> list() {
        return this.repository.list();
    }

    @Override
    public ProductCategory create(ProductCategory productCategory) {
        return this.repository.create(productCategory);
    }

    @Override
    public ProductCategory read(Integer integer) {
        return this.repository.read(integer);
    }

    @Override
    public ProductCategory update(ProductCategory productCategory) {
        return this.repository.update(productCategory);
    }

    @Override
    public boolean delete(Integer integer) {
        return this.repository.delete(integer);
    }
}
