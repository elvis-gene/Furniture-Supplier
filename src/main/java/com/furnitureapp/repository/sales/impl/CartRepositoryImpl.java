///*
//Author: Ntumba Owin
//Date of Creation: 27/8/2020
//Desc:This is the CartRepository interface, it contains the data type that will be use to store temporally the cart.
//     Carts (Cart class objects) will not be saved in any database.
//     They will just exist in the browser using sessions (creation, update, & deletion).
// */
//package com.furnitureapp.repository.sales.impl;
//
//import com.furnitureapp.entity.sales.Cart;
//import com.furnitureapp.entity.sales.Promotion;
//import com.furnitureapp.repository.sales.CartRepository;
//import com.furnitureapp.repository.sales.PromotionRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class CartRepositoryImpl implements CartRepository {
//
//    //Declaration of the Cart Set variable.
//    private Set<Cart> cartSet;
//
//    //Instantiation of CartRepositoryImpl class.
//    private static CartRepository cartRepository = null;
//
//    //CartRepositoryImpl constructor.
//    public CartRepositoryImpl()
//    {
//        //Giving a value to the Cart Set.
//        cartSet= new HashSet<>();
//    }
//
//    //
//    public static CartRepository getCartRepository()
//    {
//        //Checking if a CartRepository object already exist so that we can create a new one with the values that will
//        // come from the CartRepositoryImpl.
//        if (cartRepository == null)
//            cartRepository = new CartRepositoryImpl();
//        return cartRepository;
//    }
//    // All CRUD method that will be used to edit dataset
//
//    //create method will add new cart to the dataset
//    @Override
//    public Cart create(Cart cart)
//    {
//        cartSet.add(cart);
//        return cart;
//    }
//    //read method will read cartNum to update or remove value from the dataset.
//    @Override
//    public Cart read(Integer cartNum)
//    {
//        Cart cart = null;
//
//        //Going through the set to find the cart that matches the cartNum.
//        for (Cart c : this.cartSet)
//        {
//            if (c.getCartNum().equals(cartNum));
//            {
//                cart = c;
//                break;
//            }
//        }
//        return cart;
//    }
//
//    //update method will get the object and it will either delete or save the changes made to it.
//    @Override
//    public Cart update(Cart cart)
//    {
//        //get the object
//        Cart oldCart = read(cart.getCartNum());
//        //update object
//        if (oldCart != null)
//        {
//            this.cartSet.remove(oldCart);
//            this.cartSet.add(cart);
//        }
//        return cart;
//    }
//    //delete will erase the object from the dataset
//    @Override
//    public boolean delete(Integer cartNum)
//    {
//        boolean deleted = false;
//        //get the object the erase it.
//        Cart cart = read(cartNum);
//        if (cart != null) {
//            this.cartSet.remove(cart);
//            deleted = true;
//        }
//        return deleted;
//    }
//
//    //This return the dataset with all its objects
//    @Override
//    public Set<Cart> list()
//    {
//        return cartSet;
//    }
//
//
//}
