package com.furnitureapp.factory.staff;

import com.furnitureapp.entity.staff.EmployeeJob;

public class EmployeeJobFactory {

    public static EmployeeJob createEmployeeJob(Integer employeeCode, Integer jobCode){

        return new EmployeeJob.Builder()
                .build();
    }
}
