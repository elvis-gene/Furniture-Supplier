package com.furnitureapp.service.clientele.impl;
/*
 * @author: @nkosinathisola
 * Description: Customer Service Impl
 */
import com.furnitureapp.entity.clientele.Customer;
import com.furnitureapp.repository.clientele.CustomerRepository;
import com.furnitureapp.repository.clientele.impl.CustomerRepositoryImpl;
import com.furnitureapp.service.clientele.CustomerService;
import java.util.Set;

public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository repository;
    private static CustomerService customerService = null;

    private CustomerServiceImpl() {
        this.repository = CustomerRepositoryImpl.getCustomerRepository();
    }

    public static CustomerService getCustomerService(){
        if(customerService == null){
            customerService = new CustomerServiceImpl();
        }
        return customerService;
    }

    @Override
    public Customer create(Customer customer)
    {
        return this.repository.create(customer);
    }

    @Override
    public Customer read(Integer customerCode)
    {
        return this.repository.read(customerCode);
    }

    @Override
    public Customer update(Customer customerCode)
    {
        return this.repository.update(customerCode);
    }

    @Override
    public boolean delete(Integer customerCode)
    {
        return this.repository.delete(customerCode);
    }

    @Override
    public Set<Customer> list()
    {
        return this.repository.list();
    }
}