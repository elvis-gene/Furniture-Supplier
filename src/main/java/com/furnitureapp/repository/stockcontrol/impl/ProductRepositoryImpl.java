package com.furnitureapp.repository.stockcontrol.impl;

/**
 * @author @Siba182
 * Description: Implement of product repository
 */

import com.furnitureapp.entity.stockcontrol.Product;
import com.furnitureapp.entity.stockcontrol.ProductCategory;
import com.furnitureapp.factory.stockcontrol.ProductCategoryFactory;
import com.furnitureapp.factory.stockcontrol.ProductFactory;
import com.furnitureapp.repository.stockcontrol.ProductRepository;

import java.util.HashSet;
import java.util.Set;

public class ProductRepositoryImpl implements ProductRepository {
    private static ProductRepository productRepository = null;
    private Set<Product> productSet;

    public ProductRepositoryImpl() {
        productSet = new HashSet<>();

    }

    public static ProductRepository getProductRepository(){
        if (productRepository == null)
            productRepository = new ProductRepositoryImpl();
        return productRepository;
    }


    @Override
    public Product create(Product product) {
        this.productSet.add(product);
        return product;
    }

    @Override
    public Product read(Integer productCode) {
        for (Product product: this.productSet) {
            if (product.getProductCode().equals(productCode))
                return product;
        }
        return null;
    }

    @Override
    public Product update(Product product) {
        Product products = read(product.getProductCode());
        if (products != null){
            productSet.remove(products);
            productSet.add(product);
        }
        return product;
    }


    @Override
    public boolean delete(Integer productCode) {
        boolean deleted = false;

        Product products = read(productCode);
        if (products != null) {
            productSet.remove(products);
            deleted = true;
        }
        return deleted;
    }

    @Override
    public Set<Product> list() {
        return this.productSet;
    }
}

