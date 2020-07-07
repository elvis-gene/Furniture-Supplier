package com.furnitureapp.factory.clientele;

import com.furnitureapp.entity.clientele.Customer;
import com.furnitureapp.utility.Helper;

public class CustomerFactory {
    public static Customer createCustomer(String fullName, String emailAddress, String phoneNumber, String address, String password){
        int customerCode = Helper.generateCode();

        return new Customer.CustomerBuilder()
                .setCustomerCode(customerCode)
                .setFullName(fullName)
                .setEmailAddress(emailAddress)
                .setPhoneNumber(phoneNumber)
                .setAddress(address)
                .setPassword(password).build();
    }
}
