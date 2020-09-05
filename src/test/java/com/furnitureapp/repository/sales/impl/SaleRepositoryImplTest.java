package com.furnitureapp.repository.sales.impl;

import com.furnitureapp.entity.sales.Sale;
import com.furnitureapp.entity.sales.SaleProduct;
import com.furnitureapp.factory.sales.SaleFactory;
import com.furnitureapp.factory.sales.SaleProductFactory;
import com.furnitureapp.repository.sales.SaleRepository;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SaleRepositoryImplTest {

    private static SaleRepository saleRepository = SaleRepositoryImpl.getSaleRepository();
    private static Sale sale = SaleFactory.createSale(
                    new HashSet<>(Collections.singletonList(SaleProductFactory.
                            createSaleProduct(435, 2))
                    ));

    @Test
    public void b_create() {
        Sale createdSale = saleRepository.create(sale);
        assertEquals(createdSale, sale);
        System.out.println("created " + createdSale);
    }

    // Null if the sale object is deleted before this method is tested.
    @Test
    public void c_read() {
        Sale readSale = saleRepository.read(sale.getSaleCode());
        assertEquals(readSale, sale);
        System.out.println("Read " + readSale);
    }

    @Test
    public void d_update() {
        Sale updatedSale = new Sale.SaleBuilder().copy(sale).setTotalAmount(400).build();
        saleRepository.update(updatedSale);
        assertNotEquals(sale, updatedSale);
        System.out.println("Updated sale: " + updatedSale);
    }

    @Test
    public void e_delete() {
        saleRepository.delete(sale.getSaleCode());
        assertNull(saleRepository.read(sale.getSaleCode()));
    }

    @Test
    public void list() {
        Set<Sale> sales = saleRepository.list();
        assertEquals(sales.size(), 0);
    }
}
