/*
Author: Ntumba Owin
Date of Creation: 25/9/2020
Desc:This is the CartController class, implements of the rest controller.

 */
package com.furnitureapp.controller.sales;

import com.furnitureapp.entity.sales.Cart;
import com.furnitureapp.service.sales.impl.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartServiceImpl cartService;

    @PostMapping("/create")
    public Cart create(@RequestBody final Cart cart){
        //Cart newCart = CartFactory.createCart(cart.getCartItems(),cart.getNumbItems(),cart.getTotal());
        return cartService.create(cart);
    }
    @GetMapping("/read/{cartID}")
    public Cart read(@PathVariable Integer cartID){
        return cartService.read(cartID);
    }
    @PostMapping("/update")
    public Cart update(@RequestBody Cart cart){
        return cartService.update(cart);
    }
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Integer id){
        return cartService.delete(id);
    }
    @GetMapping("/list")
    public Set<Cart> list(){
        return cartService.list();
    }
}
