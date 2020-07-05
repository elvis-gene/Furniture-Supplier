/*
Author: Ntumba Owin
Date of Creation: 4/7/2020
Desc: This is the Cart class, it keeps track of all the items the customer wan to buy.

 */
package com.furnitureapp.entity;

import java.util.List;

public class Cart {
    List <SaleProduct> item;
    private int numbItem;
    private double total;

    //Constructor
    public Cart(CartBuilder builder) {
        this.numbItem= builder.numbItem;
        this.total = builder.total;
    }
    //Getters

    public List<SaleProduct> getItem() { return item; }

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
                "item=" + item +
                ", numbItem=" + numbItem +
                ", total=" + total +
                '}';
    }

    //Builder Pattern Design implementation
    public static class CartBuilder{
        //All attributes inside builder class
        private int numbItem;
        private double total;

        //Setters
//        public CartBuilder setItem(Product item){
//            this.item = item;
//            return this;
//        }
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
            this.numbItem = cart.numbItem;
            this.total = cart.total;
            return this;
        }

        //Create a CartBuilder constructor
        public Cart build(){ return new Cart(this);  }
    }
}
