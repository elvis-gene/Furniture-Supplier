package com.furnitureapp.repository.clientele.impl;
/*
 * @author: @nkosinathisola
 * Description: Customer Repository Impl Tests
 */
import com.furnitureapp.entity.clientele.Customer;
import com.furnitureapp.factory.clientele.CustomerFactory;
import com.furnitureapp.repository.clientele.CustomerRepository;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertNotEquals;

public class CustomerRepositoryImplTest extends TestCase {
    private static CustomerRepository repo = CustomerRepositoryImpl.getCustomerRepository();
    private static Customer customer = CustomerFactory.createCustomer("Nkosinathi Sola",
            "nkosinathisola@gmail.com",
            "0825173224",
            "24 Lancaster Street Claremont, Cape Town RSA",
            "password123");

    @Test
    public void create_customer() {
        Customer created = repo.create(customer);
        assertEquals(created, customer);
        System.out.println("Create: " + created);
    }

    @Test
    public void read_customer() {
        Customer read = repo.read(customer.getCustomerCode());
        assertEquals(read.getCustomerCode(), customer.getCustomerCode());
        System.out.println("Read: " + read);
    }

    @Test
    public void update_customer() {
        Customer updated = new Customer.CustomerBuilder().copy(customer).setFullName("Emanuel Skye").build();
        updated = repo.update(updated);
        assertNotEquals(updated, customer);
        System.out.println("Update: " + updated);
    }

    @Test
    public void delete_customer() {
        repo.delete(customer.getCustomerCode());
        System.out.println("Employee deleted");
    }

    @Test
    public void list() {
        Set<Customer> customers = repo.list();
        assertEquals(0, customers.size());
    }

}