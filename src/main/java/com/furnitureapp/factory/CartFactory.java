/*
Author: Ntumba Owin
Date of Creation: 4/7/2020
Desc:This is the CartFactory class, it help with the encapsulation of all the object of the Cart class.

 */

package com.furnitureapp.factory;

import com.furnitureapp.entity.Cart;
import com.furnitureapp.entity.SaleProduct;

public class CartFactory {

    public CartFactory(){}
    public static Cart createCart(SaleProduct cartItems, int numItem, double total){
        //create a new Cart object
        Cart cart = null;
             cart = new Cart.CartBuilder()
                    .setCartItem(cartItems)
                    .setNumbItem(numItem)
                    .setTotal(total)
                    .build();
            return cart;
        }

}
