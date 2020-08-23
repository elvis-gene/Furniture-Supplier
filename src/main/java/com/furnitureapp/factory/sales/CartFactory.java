/*
Author: Ntumba Owin
Date of Creation: 4/7/2020
Desc:This is the CartFactory class, it help with the encapsulation of all the object of the Cart class.

 */

package com.furnitureapp.factory.sales;

import com.furnitureapp.entity.sales.Cart;
import com.furnitureapp.entity.sales.SaleProduct;
import com.furnitureapp.utility.Helper;

import java.util.List;

public class CartFactory {

    public CartFactory(){}
    public static Cart createCart(List<SaleProduct> cartItems, int numItem, double total){
        //create a new Cart object
        return new Cart.CartBuilder()
                        .setCartNum(Helper.generateCode())
                        .setCartItems(cartItems)
                        .setNumbItems(numItem)
                        .setTotal(total)
                        .build();
        }

}
