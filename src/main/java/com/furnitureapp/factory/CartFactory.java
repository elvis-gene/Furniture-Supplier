/*
Author: Ntumba Owin
Date of Creation: 4/7/2020
Desc:This is the CartFactory class, it help with the encapsulation of all the object of the Cart class.

 */

package com.furnitureapp.factory;

import com.furnitureapp.entity.Cart;

public class CartFactory {

    public static Cart createCart(String itemDescription,int numItem, double total){
        //create a new Cart object
        Cart cart = null;

        //Check if there is a cart in the system
        //if the cart does not exist create a new one
        if(cart == null)
        {
            cart = new Cart.CartBuilder()
                    .setItemDescription(itemDescription)
                    .setNumbItem(numItem)
                    .setTotal(total)
                    .build();
            return cart;
        }
        //if there is an existing cart do not create one
        else {
            return null;
        }
    }
}
