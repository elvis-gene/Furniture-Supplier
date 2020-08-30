/*
Author: Ntumba Owin
Date of Creation: 4/7/2020
This is the Cart class, it keep tracks of all the items the customer wan to buy.

 */
package com.furnitureapp.entity.sales;

import java.util.List;

public class Cart {
    //All attributes
    private Integer cartNum;
    private List <SaleProduct> cartItems;
    private int numbItems;
    private double total;

    //Constructor
    private Cart(CartBuilder builder) {
        this.cartNum = builder.cartNum;
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

    public Integer getCartNum() {
        return cartNum;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartNum=" + cartNum +
                ", cartItems=" + cartItems +
                ", numbItems=" + numbItems +
                ", total=" + total +
                '}';
    }

    //Builder Pattern Design implementation
    public static class CartBuilder{
        //All attributes inside builder class
        private Integer cartNum;
        private List<SaleProduct> cartItems;
        private int numbItems;
        private double total;

        //constructor
        public CartBuilder(){}

        //Setters

        public CartBuilder setCartNum(Integer cartNum){
            this.cartNum = cartNum;
            return this;
        }

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
            this.cartNum = cart.cartNum;
            this.cartItems = cart.cartItems;
            this.numbItems = cart.numbItems;
            this.total = cart.total;
            return this;
        }

        //Create a CartBuilder constructor
        public Cart build(){ return new Cart(this);  }
    }
}
