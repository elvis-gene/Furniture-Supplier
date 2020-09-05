/*
    Coder: Elvis Gene
    Description: Sale entity services
    Date: 05-Sept-2020
 */

package com.furnitureapp.service.sales.impl;

import com.furnitureapp.entity.sales.Sale;
import com.furnitureapp.repository.sales.SaleRepository;
import com.furnitureapp.repository.sales.impl.SaleRepositoryImpl;
import com.furnitureapp.service.sales.SaleService;

import java.util.Set;

public class SaleServiceImpl implements SaleService {

    private static SaleService saleService = null;
    private SaleRepository saleRepository;

    public SaleServiceImpl(){
        this.saleRepository = SaleRepositoryImpl.getSaleRepository();
    }

    public static SaleService getSaleService() {
        if (saleService == null)
            saleService = new SaleServiceImpl();
        return saleService;
    }

    @Override
    public Set<Sale> list() {
        return saleRepository.list();
    }

    @Override
    public Sale create(Sale sale) {
        return saleRepository.create(sale);
    }

    @Override
    public Sale read(Integer saleId) {
        return saleRepository.read(saleId);
    }

    @Override
    public Sale update(Sale sale) {
        return saleRepository.update(sale);
    }

    @Override
    public boolean delete(Integer saleId) {
        return saleRepository.delete(saleId);
    }

    @Override
    public Set<Sale> monthlySales() {
        return saleRepository.monthlySales();
    }

    @Override
    public double monthlySalesAmount() {
        return saleRepository.monthlySalesAmount();
    }
}
