package com.furnitureapp.service.distribution.impl;

import com.furnitureapp.entity.distribution.Delivery;
import com.furnitureapp.repository.distribution.DeliveryRepository;
//import com.furnitureapp.repository.distribution.impl.DeliveryRepositoryImpl;
import com.furnitureapp.service.distribution.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Set;
import java.util.stream.Collectors;


@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

//    public DeliveryServiceImpl(){
//        this.deliveryRepository.findAll().stream().collect(Collectors.toSet());
//    }

//    public static DeliveryService getDeliveryService() {
//        if (deliveryService == null)
//            deliveryService = new DeliveryServiceImpl();
//        return deliveryService;
//    }

    @Override
    public Set<Delivery> list() {

        return  this.deliveryRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Delivery create(Delivery delivery) {
        return this.deliveryRepository.save(delivery);
    }

    @Override
    public Delivery read(Integer deliveryCode) {

        return this.deliveryRepository.findById(deliveryCode).orElseGet(null);
    }

    @Override
    public Delivery update(Delivery delivery) {

        return create(delivery);
    }

    @Override
    public boolean delete(Integer deliveryCode) {

       this.deliveryRepository.deleteById(deliveryCode);
       if(this.deliveryRepository.existsById(deliveryCode)) return false;
       return true;
    }


}
