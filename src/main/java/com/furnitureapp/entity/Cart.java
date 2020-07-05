/*
Author: Ntumba Owin
Date of Creation: 4/7/2020
This is the Cart class, it keep tracks of all the items the customer wan to buy.

 */
package com.furnitureapp.entity;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    //All attributes
    List <SaleProduct> cartItems;
    private int numbItems;
    private double total;

    //Constructor
    private Cart(CartBuilder builder) {
        this.cartItems =  builder.cartItems;
        this.numbItems = builder.numbItems;
        this.total = builder.total;
    }

    //Getters


    public List<SaleProduct> getCartItems() {
        return cartItems;
    }

    public int getNumbItems() {
        return numbItems;
    }

    public double getTotal() {
        return total;
    }

    //Display with toString
    @Override
    public String toString() {
        return "Cart{" +
                "cartItems=" + cartItems +
                ", numbItmes=" + numbItems +
                ", total=" + total +
                '}';
    }

    //Builder Pattern Design implementation
    public static class CartBuilder{
        //All attributes inside builder class
        private List<SaleProduct> cartItems;
        private int numbItems;
        private double total;
        //constructor
        public CartBuilder(){}
        //Setters
        public CartBuilder setCartItems(List<SaleProduct> cartItems) {
            this.cartItems = cartItems;
            return this;
        }

        public CartBuilder setNumbItems(int numbItems) {
            this.numbItems = numbItems;
            return this;
        }

        public CartBuilder setTotal(double total) {
            this.total = total;
            return this;
        }

        //Copy of the class Cart
        public CartBuilder copy(Cart cart){
            this.numbItems = cart.numbItems;
            this.numbItems = cart.numbItems;
            this.total = cart.total;
            return this;
        }

        //Create a CartBuilder constructor
        public Cart build(){ return new Cart(this);  }
    }
}
