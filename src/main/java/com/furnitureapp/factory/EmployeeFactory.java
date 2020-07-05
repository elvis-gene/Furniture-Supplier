package com.furnitureapp.factory;

/*
 * @author: @yaseenjohnston
 * Description: Factory for Employee entity
 */

import com.furnitureapp.entity.Employee;
import com.furnitureapp.entity.Job;
import com.furnitureapp.utility.Helper;

public class EmployeeFactory {

    public static Employee createEmployee(String fullName, String address, String emailAddress, String phone, String shift, double salary, String passCode, Job job){

        Employee employee = new Employee.EmployeeBuilder()
                .setEmployeeCode(Helper.generateCode())
                .setFullName(fullName)
                .setAddress(address)
                .setEmailAddress(emailAddress)
                .setPhone(phone)
                .setShift(shift)
                .setSalary(salary)
                .setPassCode(passCode)
                .setJob(job)
                .build();
        return employee;
    }

}
