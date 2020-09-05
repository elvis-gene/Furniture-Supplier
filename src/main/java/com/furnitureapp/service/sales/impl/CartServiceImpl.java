/*
Author: Ntumba Owin
Date of Creation: 3/9/2020
Desc:This is the CartServiceImpl class, it implements the CartService Interface.

 */

package com.furnitureapp.service.sales.impl;

import com.furnitureapp.entity.sales.Cart;
import com.furnitureapp.repository.sales.CartRepository;
import com.furnitureapp.repository.sales.impl.CartRepositoryImpl;
import com.furnitureapp.service.sales.CartService;
import java.util.Set;

public class CartServiceImpl implements CartService {

    //Instantiation of a CartService object and a CartRepository object.
        private static CartService service = null;
        private CartRepository repository;

   //Initialisation of the repository object with values coming from the CartRepositoryImpl
        private CartServiceImpl()
        {
            this.repository = CartRepositoryImpl.getCartRepository();
        }

   //Constructor checking if there is an existing service
        public static CartService getService()
        {
            if (service == null)
            {
                service = new CartServiceImpl();
            }
            return service;
        }

    @Override
        public Set<Cart> list()
        {
            return this.repository.list();
        }

    @Override
        public Cart create(Cart cart)
        {
            return this.repository.create(cart);
        }

    @Override
        public Cart read(Integer cardID)
        {
            return this.repository.read(cardID);
        }

    @Override
        public Cart update(Cart cart)
        {
            return this.repository.update(cart);
        }

    @Override
        public boolean delete(Integer cartID)
        {
            this.repository.delete(cartID);
            return true;
        }
}
