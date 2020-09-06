/*
Author: Ntumba Owin
Date of Creation: 27/8/2020
Desc:This is the CartRepository interface, it contains the data type that will be use to store the cart created by the customer.

 */
package com.furnitureapp.repository.sales;

import com.furnitureapp.entity.sales.Cart;
import com.furnitureapp.entity.sales.Promotion;
import com.furnitureapp.repository.IRepository;

import java.util.Set;

public interface CartRepository extends IRepository<Cart, Integer> {
    
    //Creation of the set that will contain the Cart objects and on which the CRUD method will be applied
     Set<Cart>list();
}
