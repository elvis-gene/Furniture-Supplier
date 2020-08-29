package com.furnitureapp.repository.stockcontrol;

import com.furnitureapp.entity.stockcontrol.ProductCategory;
import com.furnitureapp.repository.IRepository;

import java.util.Set;

public interface ProductCategoryRepository extends IRepository<ProductCategory, Integer> {
    Set<ProductCategory> list();
}
