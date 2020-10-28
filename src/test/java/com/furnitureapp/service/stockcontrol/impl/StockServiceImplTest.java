package com.furnitureapp.service.stockcontrol.impl;

import com.furnitureapp.entity.stockcontrol.Stock;
import com.furnitureapp.factory.stockcontrol.StockFactory;
import com.furnitureapp.service.stockcontrol.StockService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StockServiceImplTest {

    @Autowired
    private static StockService service;
    // TODO: With database, input product category code.
    private static Stock stock = StockFactory.createStock(89);

    @Test
    public void list() {
        Set<Stock> stocks = service.list();
        assertEquals(0, stocks.size());
    }

    @Test
    public void a_create() {
        Stock created = service.create(stock);
        assertEquals(stock, created);
        System.out.println("New Stock: "+ created);
    }

    @Test
    public void b_read() {
        Stock readStock = service.read(stock.getProdCatCode());
        assertEquals(stock, readStock);
        System.out.println("Read stock: "+ readStock);
    }

    @Test
    public void c_update() {
        Stock updatedStock = new Stock.StockBuilder().copy(stock).setQuantity(78).build();
        updatedStock = service.update(updatedStock);
        System.out.println("Updated stock: "+ updatedStock);
    }

    @Test
    public void d_delete() {
        boolean deleted = service.delete(stock.getProdCatCode());
        assertTrue(deleted);
    }
}
