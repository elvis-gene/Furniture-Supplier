/*
Author: Ntumba Owin
Date of Creation: 3/9/2020
Desc:This is the PromotionServiceImplTest class, tests the implementation of different business rules.

 */

package com.furnitureapp.service.sales.impl;

import com.furnitureapp.entity.sales.Cart;
import com.furnitureapp.entity.sales.SaleProduct;
import com.furnitureapp.factory.sales.CartFactory;
import com.furnitureapp.factory.sales.SaleProductFactory;
import com.furnitureapp.service.sales.CartService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Set;

import static org.junit.Assert.assertEquals;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CartServiceImplTest {

    //Creation of an Arraylist to store cartItems
    ArrayList<SaleProduct> cartItems = new ArrayList<>();

    //Instantiation of an object of the class CartRepositoryImpl
    //And creation of a cart object
    private static CartService service = CartServiceImpl.getService();
    private static Cart cart;

    //create a new cart
    @Test
    public void a_create()
    {
        cartItems.add(SaleProductFactory.createSaleProduct( 152,3));
        cart = CartFactory.createCart(cartItems, 2, 6000);
        Cart createCart = service.create(cart);
        Assert.assertEquals(cart.getCartNum(),createCart.getCartNum());
        System.out.println("Creation of new cart: " +createCart);
    }
    @Test
    public void d_getAll()
    {
        Set<Cart> carts = service.getAll();
        assertEquals(1,carts.size());
    }

    @Test
    public void b_read()
    {
        Cart read = service.read(cart.getCartNum());
        System.out.println("Read cart: " +read);
    }

    @Test
    public void c_update()
    {
        Cart updated = new Cart.CartBuilder().copy(cart).setNumbItems(4).build();
        updated = service.update(updated);
        System.out.println("Updated cart: " +updated);
    }

    @Test
    public void e_delete()
    {
        service.delete(cart.getCartNum());
        System.out.println("Promotion deleted!");
    }
}
