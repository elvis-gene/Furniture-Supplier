package com.furnitureapp.repository.stockcontrol.impl;

/**
 * @author @Siba182
 * Description: Implement of product category repository
 */

import com.furnitureapp.entity.stockcontrol.ProductCategory;
import com.furnitureapp.repository.stockcontrol.ProductCategoryRepository;

import java.util.HashSet;
import java.util.Set;

public class ProductCategoryRepositoryImpl implements ProductCategoryRepository {
    private static ProductCategoryRepository productCategoryRepository = null;
    private Set<ProductCategory> productCategories;

    public ProductCategoryRepositoryImpl() {
        productCategories = new HashSet<>();
    }

    public static ProductCategoryRepository getProductCategoryRepository() {
        if (productCategoryRepository == null)
            productCategoryRepository = new ProductCategoryRepositoryImpl();
        return productCategoryRepository;
    }

    @Override
    public ProductCategory create(ProductCategory productCategory) {
        this.productCategories.add(productCategory);
        return productCategory;
    }

    @Override
    public ProductCategory read(Integer categoryCode) {
        for (ProductCategory productCategory : this.productCategories) {
            if (productCategory.getCategoryCode().equals(categoryCode))
                return productCategory;
        }
        return null;
    }

    @Override
    public ProductCategory update(ProductCategory productCategory) {
        ProductCategory category = read(productCategory.getCategoryCode());
        if (category != null) {
            productCategories.remove(category);
            productCategories.add(productCategory);
        }
        return null;
    }

    @Override
    public void delete(Integer categoryCode) {
        ProductCategory category = read(categoryCode);
        if (category != null)
            productCategories.remove(category);


    }

    @Override
    public Set<ProductCategory> list() {
        return this.productCategories;
    }
}
