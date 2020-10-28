//package com.furnitureapp.repository.clientele.impl;
///*
// * @author: @nkosinathisola
// * Description: Customer Repository Impl Tests
// */
//import com.furnitureapp.entity.clientele.Customer;
//import com.furnitureapp.factory.clientele.CustomerFactory;
//import com.furnitureapp.repository.clientele.CustomerRepository;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//
//import java.util.Set;
//
//import static org.junit.Assert.*;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//
//public class CustomerRepositoryImplTest{
//    private static CustomerRepository repo = CustomerRepositoryImpl.getCustomerRepository();
//    private static Customer customer = CustomerFactory.createCustomer("Nkosinathi Sola",
//            "nkosinathisola@gmail.com",
//            "0825173224",
//            "24 Lancaster Street Claremont, Cape Town RSA",
//            "password123");
//
//    @Test
//    public void a_create_customer() {
//        Customer created = repo.create(customer);
//        assertEquals(created, customer);
//        System.out.println("Create: " + created);
//    }
//
//    @Test
//    public void b_read_customer() {
//        Customer read = repo.read(customer.getCustomerCode());
//        assertEquals(read.getCustomerCode(), customer.getCustomerCode());
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    public void c_update_customer() {
//        Customer updated = new Customer.CustomerBuilder().copy(customer).setFullName("Emanuel Skye").build();
//        updated = repo.update(updated);
//        assertNotEquals(updated, customer);
//        System.out.println("Update: " + updated);
//    }
//
//    @Test
//    public void d_delete_customer() {
//       boolean deleted = repo.delete(customer.getCustomerCode());
//       assertTrue(deleted);
//    }
//
//    @Test
//    public void list() {
//        Set<Customer> customers = repo.list();
//        assertEquals(0, customers.size());
//    }
//
//}
