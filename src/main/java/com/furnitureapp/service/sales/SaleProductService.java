/*
    Coder: Elvis Gene
    Description: Interface for SaleProductServiceImpl
    Date: 05-Sept-2020
 */

package com.furnitureapp.service.sales;

import com.furnitureapp.entity.sales.SaleProduct;
import com.furnitureapp.entity.sales.SaleProductCode;

import java.util.Set;

// Services of a bridge entity
public interface SaleProductService {

    SaleProduct read(SaleProductCode id);
    SaleProduct create(SaleProduct saleProduct);
    SaleProduct update(SaleProduct saleProduct);
    boolean delete(SaleProductCode id);
    Set<SaleProduct> list();
}
