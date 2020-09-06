package com.furnitureapp.service.stockcontrol;

import com.furnitureapp.entity.stockcontrol.ProductCategory;
import com.furnitureapp.service.IService;

import java.util.Set;

public interface ProductCategoryService extends IService <ProductCategory, Integer> {
    Set<ProductCategory> list();

}
