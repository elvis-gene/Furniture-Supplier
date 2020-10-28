package com.furnitureapp.repository.distribution;

import com.furnitureapp.entity.distribution.Delivery;
import com.furnitureapp.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {

    Set<Delivery> list();

}
