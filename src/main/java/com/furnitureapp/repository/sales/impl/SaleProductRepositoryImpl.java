/*
    Coder: Elvis Gene
    Description: CRUD methods for the SaleProduct entity
    Date:
 */

package com.furnitureapp.repository.sales.impl;
import com.furnitureapp.entity.sales.SaleProduct;
import com.furnitureapp.repository.sales.SaleProductRepository;

import java.util.HashSet;
import java.util.Set;

public class SaleProductRepositoryImpl implements SaleProductRepository {
    /**
     *      The sale product id could be the concatenation of the product id
     *      and the sale id as a result of SaleProduct being the bridge entity
     *      And since the sale code will always be different, the product although
     *      it might repeat for different sales, the combination of both the
     *      the sale code and product code will always be unique. This means a set
     *      is the appropriate data type.
     */

    private Set<SaleProduct> saleProducts;

    public SaleProductRepositoryImpl() {
        saleProducts = new HashSet<>();
    }

    @Override
    public SaleProduct create(SaleProduct saleProduct){
        saleProducts.add(saleProduct);
        return saleProduct;
    }

    // Use sale code & product code to read
    @Override
    public SaleProduct read(Long saleCode, Long prodCode){
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
    public void delete(Long saleCode, Long prodCode){
        SaleProduct saleProduct = read(saleCode, prodCode);
        if (saleProduct != null)
            saleProducts.remove(saleProduct);
    }

    @Override
    public Set<SaleProduct> list() {
        return saleProducts;
    }
}
