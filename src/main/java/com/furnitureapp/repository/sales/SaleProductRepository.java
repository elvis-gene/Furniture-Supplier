/*
    Coder: Elvis Gene
    Description: Interface for SaleProductRepositoryImpl
    Date: 29-Aug-2020
 */

package com.furnitureapp.repository.sales;

import com.furnitureapp.entity.sales.SaleProduct;
import com.furnitureapp.entity.sales.SaleProductCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface SaleProductRepository extends JpaRepository<SaleProduct, SaleProductCode> {
}
