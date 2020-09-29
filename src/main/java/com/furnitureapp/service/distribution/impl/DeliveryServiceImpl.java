package com.furnitureapp.service.distribution.impl;

import com.furnitureapp.entity.distribution.Delivery;
import com.furnitureapp.repository.distribution.DeliveryRepository;
import com.furnitureapp.repository.distribution.impl.DeliveryRepositoryImpl;
import com.furnitureapp.service.distribution.DeliveryService;
import org.springframework.stereotype.Service;


import java.util.Set;


@Service
public class DeliveryServiceImpl implements DeliveryService {
    private static DeliveryService deliveryService = null;
    private DeliveryRepository deliveryRepository;

    public DeliveryServiceImpl(){
        this.deliveryRepository = DeliveryRepositoryImpl.getDeliveryRepository();
    }

    public static DeliveryService getDeliveryService() {
        if (deliveryService == null)
            deliveryService = new DeliveryServiceImpl();
        return deliveryService;
    }

    @Override
    public Set<Delivery> list() {
        return deliveryRepository.list();
    }

    @Override
    public Delivery create(Delivery delivery) {
        return deliveryRepository.create(delivery);
    }

    @Override
    public Delivery read(Integer deliveryCode) {
        return deliveryRepository.read(deliveryCode);
    }

    @Override
    public Delivery update(Delivery delivery) {
        return deliveryRepository.update(delivery);
    }

    @Override
    public boolean delete(Integer deliveryCode) {
        return deliveryRepository.delete(deliveryCode);
    }


}
