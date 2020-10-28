/*
package com.furnitureapp.repository.sales.impl;
import com.furnitureapp.entity.sales.SaleProduct;
import com.furnitureapp.factory.sales.SaleProductFactory;
import com.furnitureapp.repository.sales.SaleProductRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SaleProductRepositoryImplTest {
    private static SaleProductRepository saleProductRepository = SaleProductRepositoryImpl.getSaleProductRepository();
    private static SaleProduct saleProduct = SaleProductFactory.createSaleProduct(435, 4);

    @Test
    public void a_create() {
        SaleProduct createdSP = saleProductRepository.create(saleProduct);
        assertEquals(createdSP, saleProduct);
        System.out.println("Created sale product: "+ createdSP);
    }

    // The following test passes if the read object exists in the set. Otherwise it fails
    @Test
    public void b_read() {
        SaleProduct readSP = saleProductRepository.read(saleProduct.getSaleCode(), saleProduct.getProdCode());
        assertEquals(readSP, saleProduct);
        System.out.println("Read sale product " + readSP);
    }

    @Test
    public void c_update() {
        SaleProduct updatedSP = new SaleProduct.Builder().copy(saleProduct).setQuantity(5).build();
        updatedSP = saleProductRepository.update(updatedSP);
        assertNotEquals(updatedSP, saleProduct);
        System.out.println("Updated sale product: "+ updatedSP);
    }

    @Test
    public void d_delete() {
        boolean deleted = saleProductRepository.delete(saleProduct.getSaleCode(), saleProduct.getProdCode());
        assertTrue(deleted);
    }

    @Test
    public void list() {
        Set<SaleProduct> saleProducts = saleProductRepository.list();
        assertEquals(saleProducts.size(), 0);
    }

}

 */
