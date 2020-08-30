/*
    Coder: Elvis Gene
    Description: CRUD methods for the Sale entity
    Date: 29-Aug-2020
 */

package com.furnitureapp.repository.sales.impl;

import com.furnitureapp.entity.sales.Sale;
import com.furnitureapp.entity.sales.SaleProduct;
import com.furnitureapp.factory.sales.SaleFactory;
import com.furnitureapp.factory.sales.SaleProductFactory;
import com.furnitureapp.repository.sales.SaleRepository;

import java.util.HashSet;
import java.util.Set;

public class SaleRepositoryImpl implements SaleRepository {

    // Using 'Set' as each sale is unique
    private Set<Sale> sales;
    private static SaleRepository saleRepository = null;

    public SaleRepositoryImpl() {
        sales = new HashSet<>();

        /*
         The following code has the goal of allowing me to run my test method in any order.
         If I already have a sale object in the sales set, the read or delete method
         can be run before the create. This ensures that all my test methods are
         independent of each other and I don't have the use the annotation
         @FixMethodOrder
         */
        Set<SaleProduct> saleProducts = new HashSet<>();
        saleProducts.add(SaleProductFactory.createSaleProduct(435,5));

        sales.add(SaleFactory.createSale(saleProducts));
    }

    public static SaleRepository getSaleRepository(){
        if (saleRepository == null)
            saleRepository = new SaleRepositoryImpl();
        return saleRepository;
    }

    @Override
    public Sale create(Sale sale){
        sales.add(sale);
        return sale;
    }

    @Override
    public Sale read(Integer saleCode){
        return sales.stream().filter(sale -> sale.getSaleCode().equals(saleCode)).
                findAny().orElse(null);
    }

    // The sale codes won't be changed so the old sale object
    // can still be referenced from the updated sale object code
    @Override
    public Sale update(Sale sale){
        Sale existingSale = read(sale.getSaleCode());
        if (existingSale != null){
            sales.remove(existingSale);
            sales.add(sale);
        }
        return sale;
    }

    @Override
    public void delete(Integer saleCode){
        Sale existingSale = read(saleCode);
        if (existingSale != null)
            sales.remove(existingSale);
    }

    @Override
    public Set<Sale> list() {
        return sales;
    }
}
