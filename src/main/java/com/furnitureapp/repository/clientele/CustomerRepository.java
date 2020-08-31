package com.furnitureapp.repository.clientele;

import com.furnitureapp.entity.clientele.Customer;
import com.furnitureapp.repository.IRepository;

import java.util.Set;

public interface CustomerRepository extends IRepository<Customer, Integer> {

    Customer create(Customer customer);
    Customer read(Integer customerCode);
    Customer update(Customer customer);
    void delete(Customer customerCode);
    Set<Customer> list();
}
