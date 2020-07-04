/*
Author: Ntumba Owin
Date of Creation: 4/7/2020
This is the Cart class, it keep tracks of all the items the customer wan to buy.

 */
package com.furnitureapp.entity;

public class Cart {
    //All attributes
    private int saleCode;
    private int numbItmes;
    private int total;

    //Constructor
    public Cart(CartBuilder builder) {
        this.saleCode = builder.saleCode;
        this.numbItmes = builder.numbItmes;
        this.total = builder.total;
    }

    //Getters
    public int getSaleCode() {
        return saleCode;
    }

    public int getNumbItmes() {
        return numbItmes;
    }

    public int getTotal() {
        return total;
    }

    //Display with toString

    @Override
    public String toString() {
        return "Cart{" +
                "saleCode=" + saleCode +
                ", numbItmes=" + numbItmes +
                ", total=" + total +
                '}';
    }

    //Builder Pattern Design implementation
    public static class CartBuilder{
        //All attributes inside builder class
        private int saleCode;
        private int numbItmes;
        private int total;

        //Setters
        public CartBuilder setSaleCode(int saleCode) {
            this.saleCode = saleCode;
            return this;
        }

        public CartBuilder setNumbItmes(int numbItmes) {
            this.numbItmes = numbItmes;
            return this;
        }

        public CartBuilder setTotal(int total) {
            this.total = total;
            return this;
        }

        //Copy of the class Cart
        public CartBuilder copy(Cart cart){
            this.saleCode = cart.saleCode;
            this.numbItmes = cart.numbItmes;
            this.total = cart.total;
            return this;
        }

        //Create a CartBuilder constructor
        public Cart build(){ return new Cart(this);  }
    }
}
