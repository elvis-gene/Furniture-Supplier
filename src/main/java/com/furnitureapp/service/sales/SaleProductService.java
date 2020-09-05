/*
    Coder: Elvis Gene
    Description: Interface for SaleProductServiceImpl
    Date: 05-Sept-2020
 */

package com.furnitureapp.service.sales;

import com.furnitureapp.entity.sales.SaleProduct;

import java.util.Set;

// Services of a bridge entity
public interface SaleProductService {

    SaleProduct read(Integer saleId, Integer prodId);
    SaleProduct create(SaleProduct saleProduct);
    SaleProduct update(SaleProduct saleProduct);
    boolean delete(Integer saleId, Integer prodId);
    Set<SaleProduct> list();
}
