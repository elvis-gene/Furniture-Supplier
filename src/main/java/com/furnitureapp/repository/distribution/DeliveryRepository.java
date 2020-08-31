package com.furnitureapp.repository.distribution;

import com.furnitureapp.entity.distribution.Delivery;
import com.furnitureapp.repository.IRepository;

import java.util.Set;

public interface DeliveryRepository extends IRepository<Delivery, Integer> {

    Set<Delivery> list();

}
