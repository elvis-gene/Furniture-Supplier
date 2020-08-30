/*
Author: Ntumba Owin
Date of Creation: 27/8/2020
Desc:This is the CartRepositoryImpl class, it contains the CRUD method for the Cart entity.
     Carts (Cart class objects) will not be saved in any database.
     They will just exist in the browser using sessions (creation, update, & deletion).
 */
package com.furnitureapp.repository.sales;

import com.furnitureapp.entity.sales.Cart;
import com.furnitureapp.repository.IRepository;

import java.util.Set;

public interface CartRepository extends IRepository<Cart, Integer> {

    //Creation of the set that will contain the Cart objects and on which the CRUD method will be applied
        Set<Cart>list();

}
