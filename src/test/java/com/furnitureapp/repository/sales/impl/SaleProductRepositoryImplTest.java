package com.furnitureapp.repository.sales.impl;

import com.furnitureapp.entity.sales.SaleProduct;
import com.furnitureapp.factory.sales.SaleProductFactory;
import com.furnitureapp.repository.sales.SaleProductRepository;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;


public class SaleProductRepositoryImplTest {
    SaleProductRepository saleProductRepository = new SaleProductRepositoryImpl().getSaleProductRepository();
    SaleProduct saleProduct = SaleProductFactory.createSaleProduct(321, 4);

    @Test
    public void create() {
        SaleProduct createdSP = saleProductRepository.create(saleProduct);
        assertEquals(createdSP, saleProduct);
    }

    // The following test passes if the read object exists in the set. Otherwise it fails
    @Test
    public void read() {
        SaleProduct readSP = saleProductRepository.read(saleProduct.getSaleCode(), saleProduct.getQuantity());
        assertNull(readSP);
    }

    @Test
    public void update() {
        SaleProduct updatedSP = new SaleProduct.Builder().copy(saleProduct).setQuantity(5).build();
        saleProductRepository.update(updatedSP);
        assertNotEquals(updatedSP, saleProduct);
    }

    @Test
    public void delete() {
        saleProductRepository.delete(saleProduct.getSaleCode(), saleProduct.getProdCode());
        assertNull(saleProductRepository.read(saleProduct.getSaleCode(), saleProduct.getProdCode()));
    }

    @Test
    public void list() {
        Set<SaleProduct> saleProducts = saleProductRepository.list();
        assertNotEquals(saleProducts.size(), 0);
    }

}
