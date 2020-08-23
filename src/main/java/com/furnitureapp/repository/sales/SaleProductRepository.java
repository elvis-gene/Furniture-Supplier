package com.furnitureapp.repository.sales;

import com.furnitureapp.entity.sales.Sale;
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

    SaleProduct read(Long saleId, Long prodId);
    SaleProduct create(SaleProduct saleProduct);
    SaleProduct update(SaleProduct saleProduct);
    void delete(Long saleId, Long prodId);
    Set<SaleProduct> list();
}
