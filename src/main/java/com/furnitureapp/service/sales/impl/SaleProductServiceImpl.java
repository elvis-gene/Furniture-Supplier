/*
    Coder: Elvis Gene
    Description: SaleProduct entity services
    Date: 05-Sept-2020
 */

package com.furnitureapp.service.sales.impl;

import com.furnitureapp.entity.sales.SaleProduct;
import com.furnitureapp.repository.sales.SaleProductRepository;
import com.furnitureapp.repository.sales.impl.SaleProductRepositoryImpl;
import com.furnitureapp.service.sales.SaleProductService;

import java.util.Set;

public class SaleProductServiceImpl implements SaleProductService {

    private SaleProductRepository repository;
    private static SaleProductService service = null;

    public SaleProductServiceImpl() {
        this.repository = SaleProductRepositoryImpl.getSaleProductRepository();
    }

    public static SaleProductService getService() {
        if (service == null)
            service = new SaleProductServiceImpl();
        return service;
    }

    @Override
    public SaleProduct read(Integer saleId, Integer prodId) {
        return repository.read(saleId, prodId);
    }

    @Override
    public SaleProduct create(SaleProduct saleProduct) {
        return repository.create(saleProduct);
    }

    @Override
    public SaleProduct update(SaleProduct saleProduct) {
        return repository.update(saleProduct);
    }

    @Override
    public boolean delete(Integer saleId, Integer prodId) {
        return repository.delete(saleId, prodId);
    }

    @Override
    public Set<SaleProduct> list() {
        return repository.list();
    }
}
