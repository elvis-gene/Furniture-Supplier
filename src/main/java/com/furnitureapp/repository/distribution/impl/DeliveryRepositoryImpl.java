//package com.furnitureapp.repository.distribution.impl;
//
//
///*
// * @author: @munashemagidi
// * Description: Repository for Delivery
// */
//import com.furnitureapp.entity.distribution.Delivery;
//import com.furnitureapp.repository.distribution.DeliveryRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class DeliveryRepositoryImpl implements DeliveryRepository {
//
//    private Set<Delivery> deliveries;
//
//    private static DeliveryRepository deliveryRepository = null;
//
//    private DeliveryRepositoryImpl() {
//        this.deliveries = new HashSet<>();
//    }
//
//    public static DeliveryRepository getDeliveryRepository() {
//        if (deliveryRepository == null) {
//            deliveryRepository = new DeliveryRepositoryImpl();
//        }
//        return deliveryRepository;
//    }
//
//    @Override
//    public Delivery create(Delivery delivery) {
//        deliveries.add(delivery);
//        return delivery;
//    }
//
//    @Override
//    public Delivery read(Integer deliveryCode) {
//        return this.deliveries.stream().filter(delivery -> delivery.getDeliveryCode()
//                .equals(deliveryCode))
//                .findAny()
//                .orElse(null);
//    }
//
//    @Override
//    public Delivery update(Delivery delivery) {
//        Delivery oldDelivery = read(delivery.getDeliveryCode());
//        if (oldDelivery != null) {
//            deliveries.remove(oldDelivery);
//            deliveries.add(delivery);
//        }
//        return delivery;
//    }
//
//    @Override
//    public boolean delete(Integer deliveryCode) {
//        boolean deleted = false;
//
//        Delivery oldDelivery = read(deliveryCode);
//        if (oldDelivery != null) {
//            deliveries.remove(oldDelivery);
//            deleted = true;
//        }
//        return deleted;
//    }
//
//    public Set<Delivery> list () {
//        return deliveries;
//    }
//}
