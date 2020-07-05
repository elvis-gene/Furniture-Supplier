/*
Author: Ntumba Owin
Date of Creation: 4/7/2020
Desc:This is the CartFactory class, it help with the encapsulation of all the object of the Cart class.

 */

package com.furnitureapp.factory;

import com.furnitureapp.entity.Cart;
import com.furnitureapp.entity.SaleProduct;

import java.util.ArrayList;
import java.util.List;

public class CartFactory {

    public CartFactory(){}
    public static Cart createCart(List<SaleProduct> cartItems, int numItem, double total){
        //create a new Cart object
        Cart cart = new Cart.CartBuilder()
                        .setCartItems(cartItems)
                        .setNumbItems(numItem)
                        .setTotal(total)
                        .build();
            return cart;
        }

}
