/*
    Coder: Elvis Gene
    Description: SaleProduct entity services
    Date: 05-Sept-2020
 */

package com.furnitureapp.service.sales.impl;

import com.furnitureapp.entity.sales.SaleProduct;
import com.furnitureapp.entity.sales.SaleProductCode;
import com.furnitureapp.repository.sales.SaleProductRepository;
import com.furnitureapp.service.sales.SaleProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SaleProductServiceImpl implements SaleProductService {

    @Autowired
    private SaleProductRepository repository;

    @Override
    public SaleProduct read(SaleProductCode id) {
        return repository.getOne(id);
    }

    @Override
    public SaleProduct create(SaleProduct saleProduct) {
        return repository.save(saleProduct);
    }

    // TODO: Alternative ─ Use embedded id for SaleProduct to implement this method just like in SaleServiceImpl
    @Override
    public SaleProduct update(SaleProduct saleProduct) {
        SaleProduct existingSaleProduct = repository.getOne(saleProduct.getId());
        BeanUtils.copyProperties(saleProduct, existingSaleProduct, "sale_code");
        return repository.saveAndFlush(existingSaleProduct);
    }

    @Override
    public boolean delete(SaleProductCode id) {
        repository.deleteById(id);
        return repository.existsById(id);
    }

    @Override
    public Set<SaleProduct> list() {
        return new HashSet<>(repository.findAll());
    }
}
