/*
Author: Ntumba Owin
Date of Creation: 3/9/2020
Desc:This is the CartService interface, it contains all the business rules to hide the functionalities of the CartRepository.
 */

package com.furnitureapp.service.sales;

import com.furnitureapp.entity.sales.Cart;
import com.furnitureapp.service.IService;

import java.util.Set;

public interface CartService extends IService<Cart, Integer> {
    //Creation of the set that will contain the Cart services
    Set<Cart>list();
}
