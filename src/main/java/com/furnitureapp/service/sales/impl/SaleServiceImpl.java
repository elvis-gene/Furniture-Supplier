/*
    Coder: Elvis Gene
    Description: Sale entity services
    Date: 05-Sept-2020
 */

package com.furnitureapp.service.sales.impl;

import com.furnitureapp.entity.sales.Sale;
import com.furnitureapp.repository.sales.SaleRepository;
import com.furnitureapp.service.sales.SaleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public Set<Sale> list() {
        return new HashSet<>(saleRepository.findAll());
    }

    @Override
    public Sale create(Sale sale) {
        return saleRepository.save(sale);
    }

    @Override
    public Sale read(Integer saleId) {
        return saleRepository.findById(saleId).orElse(null);
    }

    @Override
    public Sale update(Sale sale) {
        Sale existingSale = saleRepository.findById(sale.getSaleCode()).orElse(null);
        assert existingSale != null;
        BeanUtils.copyProperties(sale, existingSale, "sale_code");
        return saleRepository.saveAndFlush(existingSale);
    }

    @Override
    public boolean delete(Integer saleId) {
        saleRepository.deleteById(saleId);
        return !saleRepository.existsById(saleId);
    }

    @Override
    public Set<Sale> monthlySales() {
        return list().stream().filter(sale -> sale.getSaleTime().
                isAfter(LocalDateTime.now().
                        minusMonths(1))).collect(toSet());
    }

    @Override
    public double monthlySalesAmount() {
        return monthlySales().stream().mapToDouble(Sale::getTotalAmount).sum();
    }
}
