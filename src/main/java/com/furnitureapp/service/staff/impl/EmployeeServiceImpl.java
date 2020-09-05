package com.furnitureapp.service.staff.impl;

import com.furnitureapp.entity.staff.Employee;
import com.furnitureapp.repository.staff.EmployeeRepository;
import com.furnitureapp.repository.staff.impl.EmployeeRepositoryImpl;
import com.furnitureapp.service.staff.EmployeeService;


import java.util.Set;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repository;
    private static EmployeeService employeeService = null;

    private EmployeeServiceImpl() {
        this.repository = EmployeeRepositoryImpl.getEmployeeRepository();
    }

    public static EmployeeService getEmployeeService(){
        if(employeeService == null){
            employeeService = new EmployeeServiceImpl();
        }
        return employeeService;
    }

    @Override
    public Set<Employee> list() {
        return this.repository.list();
    }

    @Override
    public Employee create(Employee employee) {
        return this.repository.create(employee);
    }

    @Override
    public Employee read(Integer employeeCode) {
        return this.repository.read(employeeCode);
    }

    @Override
    public Employee update(Employee employee) {
        return this.repository.update(employee);
    }

    @Override
    public boolean delete(Integer employeeCode) {
        return this.repository.delete(employeeCode);
    }
}
