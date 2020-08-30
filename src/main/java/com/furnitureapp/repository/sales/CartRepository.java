package com.furnitureapp.repository.sales;

import com.furnitureapp.entity.sales.Cart;
import com.furnitureapp.entity.sales.Promotion;
import com.furnitureapp.repository.IRepository;

import java.util.Set;

public interface CartRepository extends IRepository<Cart, Integer> {

    Set<Cart> list();
}
