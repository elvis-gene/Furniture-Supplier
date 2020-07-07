package com.furnitureapp.factory.clientele;

import com.furnitureapp.entity.clientele.Customer;
import com.furnitureapp.factory.clientele.CustomerFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotSame;

public class CustomerFactoryTest {

    @Test
    public void createCustomer(){
        Customer cust1 = CustomerFactory.createCustomer("Nkosinathi Sola"
                , "nkosinathisola@gmail.com"
                , "0825173224"
                , "24 Lancaster Street, Claremont, Capetown"
                , "password");

        Customer cust2 = CustomerFactory.createCustomer("Sola Nkosinathi"
                ,"solankosinathi@gmail.com"
                ,"0825224173"
                ,"25 Lancaster Street, Claremont, Capetown"
                ,"password");

        assertNotSame(cust2, cust1);
    }
}
