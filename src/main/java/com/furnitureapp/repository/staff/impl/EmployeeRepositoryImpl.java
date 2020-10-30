//package com.furnitureapp.repository.staff.impl;
/*
 * @author: @yaseenjohnston
 * Description: Repository for Employee
 */
/*
import com.furnitureapp.entity.staff.Employee;
import com.furnitureapp.repository.staff.EmployeeRepository;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    //Sequence
    //create, read, update, delete


    private Set<Employee> employees;
    private static EmployeeRepository employeeRepository = null;

    private EmployeeRepositoryImpl() {
        this.employees = new HashSet<>();
    }

    public static EmployeeRepository getEmployeeRepository(){
        if(employeeRepository == null){
            employeeRepository = new EmployeeRepositoryImpl();
        }
        return employeeRepository;
    }

    @Override
    public Employee create(Employee employee){
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee read(Integer employeeCode){
        return this.employees.stream()
                    .filter(employee -> employee.getEmployeeCode()
                            .equals(employeeCode))
                            .findAny()
                            .orElse(null);
    }

    @Override
    public Employee update(Employee employee){
        Employee existingEmployee = read(employee.getEmployeeCode());
        if(existingEmployee != null){
            employees.remove(existingEmployee);
            employees.add(employee);
        }
        return employee;
    }

    @Override
    public boolean delete(Integer employeeCode){
        boolean deleted = false;

        Employee existingEmployee = read(employeeCode);
        if(existingEmployee != null){
            employees.remove(existingEmployee);
            deleted = true;
        }
        return deleted;
    }

    @Override
    public Set<Employee> list() {
        return employees;
    }

}*/
