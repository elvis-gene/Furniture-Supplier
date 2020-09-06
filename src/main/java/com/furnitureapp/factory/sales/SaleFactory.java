/*
    Coder: Elvis Gene
    Date: 05-07-2020
    Description: This class is used to instantiate Sale objects.
 */

package com.furnitureapp.factory.sales;

import com.furnitureapp.entity.sales.Sale;
import com.furnitureapp.entity.sales.SaleProduct;
import com.furnitureapp.repository.stockcontrol.ProductRepository;
import com.furnitureapp.repository.stockcontrol.impl.ProductRepositoryImpl;
import com.furnitureapp.utility.Helper;

import java.time.LocalDateTime;
import java.util.Set;


public class SaleFactory {
    private static ProductRepository productRepository = ProductRepositoryImpl.getProductRepository();

    public static Sale createSale(Set<SaleProduct> saleProducts){

        // Calculate total sale amount
        double totalAmount = 2700;
//        for (SaleProduct saleProduct : saleProducts){
//            totalAmount += productRepository.read(saleProduct.getProdCode()).getPrice();
//        }

        return new Sale.SaleBuilder()
                .setSaleCode(Helper.generateCode())
                .setSaleTime(LocalDateTime.now())
                .setSaleProducts(saleProducts)
                .setTotalAmount(totalAmount).build();
    }
}
