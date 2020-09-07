package com.furnitureapp.service.clientele;

import com.furnitureapp.entity.clientele.Customer;
import com.furnitureapp.service.IService;
import java.util.Set;

public interface CustomerService extends IService<Customer, Integer> {
    Set<Customer> list();
}