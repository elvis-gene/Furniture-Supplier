package com.furnitureapp.repository.sales;

import com.furnitureapp.entity.sales.Cart;
import com.furnitureapp.entity.sales.Promotion;
import com.furnitureapp.repository.IRepository;

import java.util.Set;

public interface CartRepository extends IRepository<Cart, Integer> {
    
    //Creation of the set that will contain the Cart objects and on which the CRUD method will be applied
     Set<Cart>list();
}
