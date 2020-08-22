package com.furnitureapp.factory.stockcontrol;

/**
 * @author @Siba182
 * Description: Factory for ProductCategory entity
 */

import com.furnitureapp.entity.stockcontrol.ProductCategory;
import com.furnitureapp.utility.Helper;

public class ProductCategoryFactory {

    public static ProductCategory createProductCategory(String categoryName){

        return new ProductCategory.ProductCategoryBuilder()
                .setCategoryCode(Helper.generateCode())
                .setCategoryName(categoryName)
                .build();
    }
}
