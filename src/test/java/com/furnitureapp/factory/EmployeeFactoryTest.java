package com.furnitureapp.factory;

import com.furnitureapp.entity.Employee;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeFactoryTest {

    @Test
    public void createEmployee(){
        Employee e1 = EmployeeFactory.createEmployee("Jake Peralta"
                , "45A Newport Avenue, Cape Town"
                , "xyz@gmail.com"
                , "0123456789"
                , "9:00 - 16:00"
                ,25000);

        Employee e2 = EmployeeFactory.createEmployee("John Doe"
                ,"42 Saturn Street, Cape Town"
                ,"abc@aol.com"
                ,"9876543210"
                ,"8:00 - 15:00"
                ,15500);

        assertNotSame(e2, e1);
    }

}