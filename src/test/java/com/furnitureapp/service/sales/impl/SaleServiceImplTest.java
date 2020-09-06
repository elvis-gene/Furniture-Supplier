package com.furnitureapp.service.sales.impl;

import com.furnitureapp.entity.sales.Sale;
import com.furnitureapp.factory.sales.SaleFactory;
import com.furnitureapp.factory.sales.SaleProductFactory;
import com.furnitureapp.service.sales.SaleService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SaleServiceImplTest {

    private static SaleService service = SaleServiceImpl.getSaleService();

    private static Sale sale = SaleFactory.createSale(
            new HashSet<>(Collections.singletonList(SaleProductFactory.
                    createSaleProduct(435, 2))
            ));

    @Test
    public void a_create() {
        Sale newSale = service.create(sale);
        assertEquals(sale, newSale);
        System.out.println("New Sale: "+ newSale);
    }

    @Test
    public void b_read() {
        Sale readSale = service.read(sale.getSaleCode());
        assertEquals(sale, readSale);
        System.out.println("Read " + readSale);
    }

    @Test
    public void c_update() {
        Sale updatedSale = new Sale.SaleBuilder().copy(sale).setTotalAmount(2000).build();
        updatedSale = service.update(updatedSale);
        assertNotEquals(sale, updatedSale);
        System.out.println("Updated sale: " + updatedSale);
    }


    @Test
    public void d_monthlySales() {
        Set<Sale> monthlySales = service.monthlySales();
        assertNotNull(monthlySales);
        System.out.println("Last Month Sales: " + monthlySales);
    }

    @Test
    public void e_monthlySalesAmount() {
        double amount = service.monthlySalesAmount();
        assertTrue(amount > 0);
        System.out.println("Monthly Total: " + amount);
    }

    @Test
    public void f_list() {
        Set<Sale> sales = service.list();
        assertEquals(1, sales.size());
        System.out.println("All sales: "+ sales);
    }

    @Test
    public void g_delete() {
        boolean deleted = service.delete(sale.getSaleCode());
        assertTrue(deleted);
        System.out.println("Sale deleted: "+ deleted);
    }
}
