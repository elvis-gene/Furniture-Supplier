package com.furnitureapp.service.distribution;

import com.furnitureapp.entity.distribution.Delivery;
import com.furnitureapp.service.IService;

import java.util.Set;

public interface DeliveryService extends IService<Delivery, Integer> {

    Set<Delivery> list();

}
