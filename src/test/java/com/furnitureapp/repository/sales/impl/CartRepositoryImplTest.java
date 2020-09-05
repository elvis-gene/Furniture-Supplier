/*
Author: Ntumba Owin
Date of Creation: 28/8/2020
Desc:This is the CartRepositoryImplTest class, it contains all the CRUD method that must be tested with JUnit4.

 */
package com.furnitureapp.repository.sales.impl;

import com.furnitureapp.entity.sales.Cart;
import com.furnitureapp.entity.sales.SaleProduct;
import com.furnitureapp.factory.sales.CartFactory;
import com.furnitureapp.factory.sales.SaleProductFactory;
import com.furnitureapp.repository.sales.CartRepository;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CartRepositoryImplTest {

    //Creation of an Arraylist to store cartItems
    ArrayList<SaleProduct> cartItems = new ArrayList<>();

    //Instantiation of an object of the class CartRepositoryImpl
    //And creation of a cart object
    private static CartRepository cartRepository = new CartRepositoryImpl();
    private static Cart cart;

    //create a new cart
    @Test
    public void a_create()
    {
        cartItems.add(SaleProductFactory.createSaleProduct( 152,3));
        cart = CartFactory.createCart(cartItems, 2, 6000);
        Cart createCart = cartRepository.create(cart);
        assertEquals(cart.getCartNum(),createCart.getCartNum());
        System.out.println("Creation: " +createCart);
    }

    //read all cartNum inside rge dataset
    @Test
    public void b_read()
    {
        Cart readCart = cartRepository.read(cart.getCartNum());
        assertEquals(readCart.getCartNum(),cart.getCartNum());
        System.out.println("Read: " +readCart);
    }

    //update specific cartNum
    @Test
    public void c_update()
    {
        Cart updatedCart = new Cart.CartBuilder().copy(cart).setNumbItems(4).build();
        updatedCart = cartRepository.update(updatedCart);
        assertNotEquals(cart.getNumbItems(),updatedCart.getNumbItems());
        System.out.println("Update: " +updatedCart);
    }

    //delete all cartNum that matches
    @Test
    public void d_delete()
    {
        boolean deleted = cartRepository.delete(cart.getCartNum());
        assertNull(cartRepository.read(cart.getCartNum()));
        System.out.println("Cart deleted");
    }

    @Test
    public void list()
    {
        Set<Cart> carts = cartRepository.list();
        assertEquals(1,carts.size());
        System.out.println(carts);
    }
}