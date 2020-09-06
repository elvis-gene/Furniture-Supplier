package com.furnitureapp.service.stockcontrol;

import com.furnitureapp.entity.stockcontrol.Product;
import com.furnitureapp.service.IService;

import java.util.Set;

public interface ProductService extends IService<Product, Integer> {
    Set<Product> list();
}
