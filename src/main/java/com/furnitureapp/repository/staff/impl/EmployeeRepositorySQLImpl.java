package com.furnitureapp.repository.staff.impl;

import com.furnitureapp.entity.staff.Employee;
import com.furnitureapp.repository.staff.EmployeeRepository;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRepositorySQLImpl implements EmployeeRepository {

    private static EmployeeRepository employeeRepository = null;

    private EmployeeRepositorySQLImpl() {
        //Link to MySql database server
    }

    public static EmployeeRepository getEmployeeRepository(){
        if(employeeRepository == null){
            employeeRepository = new EmployeeRepositorySQLImpl();
        }
        return employeeRepository;
    }


    @Override
    public Employee create(Employee employee) {
        return null;
    }

    @Override
    public Employee read(Long employeeCode) {
        return null;
    }

    @Override
    public Employee update(Employee employee) {
        return null;
    }

    @Override
    public void delete(Long employeeCode) {

    }

    @Override
    public Set<Employee> list() {
        return null;
    }
}
