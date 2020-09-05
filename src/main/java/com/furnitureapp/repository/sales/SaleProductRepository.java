package com.furnitureapp.repository.sales;

import com.furnitureapp.entity.sales.SaleProduct;

import java.util.Set;

/**
 * Due to SaleProduct being the bridge entity between Sale and Product,
 * each SaleProduct object needs to reference both the id of the sale
 * and that of a product. Which means to look for such an object, both IDs
 * need to be passed. This means, SaleProductRepository will not Repository
 * THIS MANY TO MANY RELATIONSHIP CAN BE CHANGED LATER USING HIBERNATE.
 */

public interface SaleProductRepository {

    SaleProduct read(Integer saleId, Integer prodId);
    SaleProduct create(SaleProduct saleProduct);
    SaleProduct update(SaleProduct saleProduct);
    boolean delete(Integer saleId, Integer prodId);
    Set<SaleProduct> list();
}
