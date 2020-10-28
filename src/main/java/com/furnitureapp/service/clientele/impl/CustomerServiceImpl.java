package com.furnitureapp.service.clientele.impl;
/*
 * @author: @nkosinathisola
 * Description: Customer Service Impl
 */
import com.furnitureapp.entity.clientele.Customer;
import com.furnitureapp.repository.clientele.CustomerRepository;
import com.furnitureapp.service.clientele.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public Customer create(Customer customer)
    {
        return this.repository.save(customer);
    }

    @Override
    public Customer read(Integer customerCode)
    {
        return this.repository.findById(customerCode).orElse(null);
    }

    @Override
    public Customer update(Customer customerCode)
    {
        return create(customerCode);
    }

    @Override
    public boolean delete(Integer customerCode)
    {
        this.repository.deleteById(customerCode);
        if(this.repository.existsById(customerCode)) return false;
        return true;
    }

    @Override
    public Set<Customer> list()
    {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}