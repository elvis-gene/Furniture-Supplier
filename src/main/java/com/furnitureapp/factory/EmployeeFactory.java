package com.furnitureapp.factory;

/*
 * @author: @yaseenjohnston
 * Description: Factory for Employee entity
 */

import com.furnitureapp.entity.Employee;
import com.furnitureapp.utility.Helper;

public class EmployeeFactory {

    public static Employee createEmployee(String fullName, String address, String emailAddress, String phone, String shift, double salary){

        Employee employee = new Employee.EmployeeBuilder()
                .setEmployeeCode(Helper.generateCode())
                .setFullName(fullName)
                .setAddress(address)
                .setEmailAddress(emailAddress)
                .setPhone(phone)
                .setShift(shift)
                .setSalary(salary)
                .build();
        return employee;
    }

}
