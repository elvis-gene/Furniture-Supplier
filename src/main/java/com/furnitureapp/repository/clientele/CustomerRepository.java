package com.furnitureapp.repository.clientele;

import com.furnitureapp.entity.clientele.Customer;
import com.furnitureapp.repository.IRepository;

import java.util.Set;

public interface CustomerRepository extends IRepository<Customer, Integer> {
    Set<Customer> list();
}
