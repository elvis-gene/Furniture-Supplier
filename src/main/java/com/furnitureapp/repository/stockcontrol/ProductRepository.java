package com.furnitureapp.repository.stockcontrol;

import com.furnitureapp.entity.stockcontrol.Product;
import com.furnitureapp.repository.IRepository;

import java.util.Set;

public interface ProductRepository extends IRepository<Product, Integer> {
    Set<Product> list();
}
