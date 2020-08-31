package com.furnitureapp.repository.clientele.impl;
/*
 * @author: @nkosinathisola
 * Description: Customer Repository
 */
import com.furnitureapp.entity.clientele.Customer;
import com.furnitureapp.repository.clientele.CustomerRepository;

import java.util.HashSet;
import java.util.Set;

public class CustomerRepositoryImpl implements CustomerRepository {

    private Set<Customer> customers;
    private static CustomerRepository customerRepository = null;

    private CustomerRepositoryImpl() {
        this.customers = new HashSet<>();
    }

    public static CustomerRepository getCustomerRepository() {
        if (customerRepository == null) {
            customerRepository = new CustomerRepositoryImpl();
        }
        return customerRepository;
    }

    @Override
    public Customer create(Customer customer) {
        customers.add(customer);
        return customer;
    }

    @Override
    public Customer read(Integer customerCode) {
        return this.customers.stream()
                .filter(customer -> customer.getCustomerCode()
                        .equals(customerCode))
                .findAny()
                .orElse(null);
    }

    @Override
    public Customer update(Customer appointment) {
        Customer existingCustomer = read(appointment.getCustomerCode());
        if (existingCustomer != null) {
            customers.remove(existingCustomer);
            customers.add(appointment);
        }
        return appointment;
    }

    @Override
    public void delete(Integer customerCode) {
        Customer existingCustomer = read(customerCode);
        if (existingCustomer != null) {
            customers.remove(existingCustomer);
        }
    }

    @Override
    public Set<Customer> list() {
        return customers;
    }
}

