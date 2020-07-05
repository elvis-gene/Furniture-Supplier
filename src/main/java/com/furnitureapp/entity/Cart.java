/*
Author: Ntumba Owin
Date of Creation: 4/7/2020
Desc: This is the Cart class, it keeps track of all the items the customer wan to buy.

 */
package com.furnitureapp.entity;

import java.util.List;

public class Cart {
    List <SaleProduct> cartItems;
    private int numbItem;
    private double total;

    //Constructor
    public Cart(CartBuilder builder) {
        this.cartItems = (List<SaleProduct>) builder.cartItems;
        this.numbItem= builder.numbItem;
        this.total = builder.total;
    }
    //Getters

    public List<SaleProduct> getItem() { return cartItems; }

    public int getNumbItem() {
        return numbItem;
    }

    public double getTotal() {
        return total;
    }

    //Display with toString
    @Override
    public String toString() {
        return "Cart{" +
                "item=" + cartItems +
                ", numbItem=" + numbItem +
                ", total=" + total +
                '}';
    }

    //Builder Pattern Design implementation
    public static class CartBuilder{
        //constructor
        public CartBuilder(){}
        //All attributes inside builder class
        private SaleProduct cartItems;
        private int numbItem;
        private double total;
        //builder constructor

        //Setters
        public CartBuilder setCartItem(SaleProduct cartItems){
            this.cartItems = cartItems;
            return this;
        }
         public CartBuilder setNumbItem(int numbItem) {
            this.numbItem = numbItem;
            return this;
        }

        public CartBuilder setTotal(double total) {
            this.total = total;
            return this;
        }

        //Copy of the class Cart
        public CartBuilder copy(Cart cart){
            this.cartItems = (SaleProduct) cart.cartItems;
            this.numbItem = cart.numbItem;
            this.total = cart.total;
            return this;
        }

        //Create a CartBuilder constructor
        public Cart build(){ return new Cart(this);  }
    }
}
