package com.furnitureapp.service.sales.impl;

import com.furnitureapp.entity.sales.SaleProduct;
import com.furnitureapp.factory.sales.SaleProductFactory;
import com.furnitureapp.service.sales.SaleProductService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SaleProductServiceImplTest {

    private static SaleProductService service = SaleProductServiceImpl.getService();
    private static SaleProduct saleProduct = SaleProductFactory.createSaleProduct(435, 4);


    @Test
    public void a_create() {
        SaleProduct createdSP = service.create(saleProduct);
        assertEquals(saleProduct, createdSP);
        System.out.println("New sale product: "+ createdSP);
    }

    @Test
    public void b_read() {
        SaleProduct readSP = service.read(saleProduct.getSaleCode(), saleProduct.getProdCode());
        assertEquals(saleProduct, readSP);
        System.out.println("read sale product: "+ readSP);
    }

    @Test
    public void c_update() {
        SaleProduct updatedSP = new SaleProduct.Builder().copy(saleProduct).setQuantity(5).build();
        updatedSP = service.update(updatedSP);
        assertNotEquals(saleProduct, updatedSP);
        System.out.println("Updated sale product: "+ updatedSP);
    }

    @Test
    public void d_delete() {
        boolean deleted = service.delete(saleProduct.getSaleCode(), saleProduct.getProdCode());
        assertTrue(deleted);
    }

    @Test
    public void list() {
        Set<SaleProduct> saleProducts = service.list();
        assertEquals(0, saleProducts.size());
        System.out.println("Sale products: " + saleProducts.toString());
    }
}
