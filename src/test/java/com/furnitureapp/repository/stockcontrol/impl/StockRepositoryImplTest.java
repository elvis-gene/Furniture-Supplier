package com.furnitureapp.repository.stockcontrol.impl;

import com.furnitureapp.entity.stockcontrol.Stock;
import com.furnitureapp.factory.stockcontrol.StockFactory;
import com.furnitureapp.repository.stockcontrol.StockRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StockRepositoryImplTest {

    private static StockRepository repo = StockRepositoryImpl.getStockRepository();

    // TODO: With database, input product category code.
    private static Stock stock = StockFactory.createStock(89);

    @Test
    public void a_create() {
        Stock created = repo.create(stock);
        assertEquals(created, stock);
    }

    @Test
    public void b_read() {
        Stock read = repo.read(stock.getProdCatCode());
        assertEquals(stock.getProdCatCode(), read.getProdCatCode());
    }


    @Test
    public void c_update() {
        Stock updated = new Stock.StockBuilder().copy(stock).setQuantity(78).build();
        updated = repo.update(updated);
        assertNotEquals(updated, stock);
    }


    @Test
    public void d_delete() {
        repo.delete(stock.getProdCatCode());
        System.out.println("stock deleted");
    }


    @Test
    public void e_list() {
        Set<Stock> stocks = repo.list();
        assertEquals(0, stocks.size());
    }

}
