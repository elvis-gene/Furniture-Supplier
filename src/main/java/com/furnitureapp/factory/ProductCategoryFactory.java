package com.furnitureapp.factory;

/**
 * @author @Siba182
 * Description: Factory for ProductCategory entity
 */

import com.furnitureapp.entity.ProductCategory;
import com.furnitureapp.utility.Helper;

public class ProductCategoryFactory {

    public static ProductCategory createProductCategory(String categoryName){

        ProductCategory productCategory = new ProductCategory.ProductCategoryBuilder()
                .setCategoryCode(Helper.generateCode())
                .setCategoryName(categoryName)
                .build();
        return productCategory;
    }
}
