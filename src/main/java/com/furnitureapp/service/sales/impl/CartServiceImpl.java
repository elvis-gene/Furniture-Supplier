/*
Author: Ntumba Owin
Date of Creation: 3/9/2020
Desc:This is the CartServiceImpl class, it implements the CartService Interface.

 */

package com.furnitureapp.service.sales.impl;

import com.furnitureapp.entity.sales.Cart;
import com.furnitureapp.repository.sales.CartRepository;
import com.furnitureapp.service.sales.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    //Instantiation ofa CartRepository object.
    @Autowired
        private CartRepository repository;

    @Override
        public Set<Cart> list()
        {
            return this.repository.findAll().stream().collect(Collectors.toSet());
        }

    @Override
    public Cart addProduct(Integer cartNum)
    {

//        Set<Cart> carts = list();
//        //Set<Cart> newCart = new Cart.CartBuilder();
//        for(Cart cart: carts)
//        {
//            if(cart.getCartNum().equals(cartNum))
//            {
//               // newCart =
//                // newCart.add(new CartFactory.createCart());
//            }
//        }
        return null;
    }


    @Override
        public Cart create(Cart cart)
        {
            return this.repository.save(cart);
        }

    @Override
        public Cart read(Integer cartID)
        {
            return this.repository.findById(cartID).orElse(null);
        }

    @Override
        public Cart update(Cart cart)
        {
            if (this.repository.existsById(cart.getCartNum())){
                return this.repository.save(cart);
            }
            return null;
        }

    @Override
        public boolean delete(Integer cartID)
        {
            this.repository.deleteById(cartID);
            if (this.repository.existsById(cartID)) return false;
            else return true;
        }
}
