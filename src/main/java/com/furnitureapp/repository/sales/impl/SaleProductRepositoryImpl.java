/*
    Coder: Elvis Gene
    Description: CRUD methods for the SaleProduct entity
    Date: 29-Aug-2020
 */

package com.furnitureapp.repository.sales.impl;
import com.furnitureapp.entity.sales.SaleProduct;
import com.furnitureapp.factory.sales.SaleProductFactory;
import com.furnitureapp.repository.sales.SaleProductRepository;

import java.util.HashSet;
import java.util.Set;

public class SaleProductRepositoryImpl implements SaleProductRepository {
    /**
     *      SaleProduct being the bridge entity of Product and Sale, we will need
     *      both the sale id and the product id to read/delete a product belonging to
     *      a specific sale.
     */

    private Set<SaleProduct> saleProducts;
    private static SaleProductRepository saleProductRepository = null;

    public SaleProductRepositoryImpl() {
        saleProducts = new HashSet<>();
    }

    public static SaleProductRepository getSaleProductRepository(){
        if (saleProductRepository == null)
            saleProductRepository = new SaleProductRepositoryImpl();
        return saleProductRepository;
    }

    @Override
    public SaleProduct create(SaleProduct saleProduct){
        saleProducts.add(saleProduct);
        return saleProduct;
    }

    // Use sale code & product code to read
    @Override
    public SaleProduct read(Integer saleCode, Integer prodCode){
        return saleProducts.stream().
                filter(sp -> sp.getSaleCode().equals(saleCode) && sp.getProdCode().equals(prodCode)).
                findAny().orElse(null);
    }

    @Override
    public SaleProduct update(SaleProduct saleProduct){
        SaleProduct existingSaleProduct = read(saleProduct.getProdCode(), saleProduct.getSaleCode());
        if (existingSaleProduct != null){
            saleProducts.remove(existingSaleProduct);
            saleProducts.add(saleProduct);
        }
        return saleProduct;
    }

    @Override
    public boolean delete(Integer saleCode, Integer prodCode){
        boolean deleted = false;

        SaleProduct saleProduct = read(saleCode, prodCode);
        if (saleProduct != null) {
            saleProducts.remove(saleProduct);
            deleted = true;
        }
        return deleted;
    }

    @Override
    public Set<SaleProduct> list() {
        return saleProducts;
    }
}
