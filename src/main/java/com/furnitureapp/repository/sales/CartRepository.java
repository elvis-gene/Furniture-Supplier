/*
Author: Ntumba Owin
Date of Creation: 27/8/2020
Desc:This is the CartRepository interface, it contains the data type that will be use to store the cart created by the customer.

 */
package com.furnitureapp.repository.sales;

import com.furnitureapp.entity.sales.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

}
