/*
    Coder: Elvis Gene
    Description: Interface for SaleRepositoryImpl
    Date: 29-Aug-2020
 */

package com.furnitureapp.repository.sales;

import com.furnitureapp.entity.sales.Sale;
import com.furnitureapp.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface SaleRepository extends JpaRepository<Sale, Integer> {
}
