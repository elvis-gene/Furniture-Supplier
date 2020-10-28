/*
Author: Ntumba Owin
Date of Creation: 27/8/2020
Desc:This is the CartRepository interface, it contains the data type that will be use to store the cart created by the customer.

 */
package com.furnitureapp.repository.sales;

import com.furnitureapp.entity.sales.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    
    //Creation of the set that will contain the Cart objects and on which the CRUD method will be applied
     Set<Cart>list();
}
