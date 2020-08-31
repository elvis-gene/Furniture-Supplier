package com.furnitureapp.repository.sales.impl;

import com.furnitureapp.entity.sales.Sale;
import com.furnitureapp.entity.sales.SaleProduct;
import com.furnitureapp.factory.sales.SaleFactory;
import com.furnitureapp.factory.sales.SaleProductFactory;
import com.furnitureapp.repository.sales.SaleRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class SaleRepositoryImplTest {

    private static SaleRepository saleRepository = SaleRepositoryImpl.getSaleRepository();
    Sale sale = null;

    @Before
    public void setUp() throws Exception {
        SaleProduct saleProduct = SaleProductFactory.createSaleProduct(435,2);
        Set<SaleProduct> saleProducts = new HashSet<>();
        saleProducts.add(saleProduct);

        sale = SaleFactory.createSale(saleProducts);
    }

    @Test
    public void create() {
        Sale createdSale = saleRepository.create(sale);
        assertEquals(createdSale, sale);
    }

    // Null if the sale object is deleted before this method is tested.
    @Test
    public void read() {
        Sale readSale = saleRepository.read(sale.getSaleCode());
        assertNull(readSale);
    }

    @Test
    public void update() {
        Sale updatedSale = new Sale.SaleBuilder().copy(sale).setTotalAmount(400).build();
        saleRepository.update(updatedSale);
        assertNotEquals(sale, updatedSale);
        System.out.println("Updated sale: " + updatedSale);
    }

    @Test
    public void delete() {
        saleRepository.delete(sale.getSaleCode());
        assertNull(saleRepository.read(sale.getSaleCode()));
    }

    @Test
    public void list() {
        Set<Sale> sales = saleRepository.list();
        assertNotEquals(sales.size(), 0);
    }
}
