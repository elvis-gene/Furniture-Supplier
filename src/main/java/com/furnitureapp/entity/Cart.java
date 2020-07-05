/*
Author: Ntumba Owin
Date of Creation: 4/7/2020
This is the Cart class, it keep tracks of all the items the customer wan to buy.

 */
package com.furnitureapp.entity;

public class Cart {
    //All attributes
    private int saleCode;
    private int numbItems;
    private int total;

    //Constructor
    private Cart(CartBuilder builder) {
        this.saleCode = builder.saleCode;
        this.numbItems = builder.numbItems;
        this.total = builder.total;
    }

    //Getters
    public int getSaleCode() {
        return saleCode;
    }

    public int getNumbItems() {
        return numbItems;
    }

    public int getTotal() {
        return total;
    }

    //Display with toString

    @Override
    public String toString() {
        return "Cart{" +
                "saleCode=" + saleCode +
                ", numbItmes=" + numbItems +
                ", total=" + total +
                '}';
    }

    //Builder Pattern Design implementation
    public static class CartBuilder{
        //All attributes inside builder class
        private int saleCode;
        private int numbItems;
        private int total;
        
        public CartBuilder(){}

        //Setters
        public CartBuilder setSaleCode(int saleCode) {
            this.saleCode = saleCode;
            return this;
        }

        public CartBuilder setNumbItems(int numbItems) {
            this.numbItems = numbItems;
            return this;
        }

        public CartBuilder setTotal(int total) {
            this.total = total;
            return this;
        }

        //Copy of the class Cart
        public CartBuilder copy(Cart cart){
            this.saleCode = cart.saleCode;
            this.numbItems = cart.numbItems;
            this.total = cart.total;
            return this;
        }

        //Create a CartBuilder constructor
        public Cart build(){ return new Cart(this);  }
    }
}
