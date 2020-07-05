/*
Author: Ntumba Owin
Date of Creation: 4/7/2020
Desc:This is the CartFactoryTest class, it helps with the test of all the object of the Cart class.

 */
package com.furnitureapp.factory;

import com.furnitureapp.entity.Cart;
import com.furnitureapp.entity.SaleProduct;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CartFactoryTest {

    @Test
    public void createCart() {
        //add element to the
        List <SaleProduct> cartItems = new ArrayList();
        cartItems.add(SaleProductFactory.createSaleProduct(152,3));
        //create an object of Cart class
        Cart cart = CartFactory.createCart( cartItems, 2, 6000);
        Cart cart1 = new Cart.CartBuilder().copy(cart).build();
        //asserting the objects
        Assert.assertNotEquals(cart.toString(),cart1.toString());

    }
}