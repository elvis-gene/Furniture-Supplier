package com.furnitureapp.service.staff.impl;

/*
 * @author: @yaseenjohnston
 * Description: Implementation for Employee Service
 */

import com.furnitureapp.entity.staff.Employee;
import com.furnitureapp.repository.staff.EmployeeRepository;
import com.furnitureapp.service.staff.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public Set<Employee> list() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Employee create(Employee employee) {
        return this.repository.save(employee);
    }

    @Override
    public Employee read(Integer employeeCode) {
        return this.repository.findById(employeeCode).orElseGet(null);
    }

    @Override
    public Employee update(Employee employee) {
        return create(employee);
    }

    @Override
    public boolean delete(Integer employeeCode) {
        this.repository.deleteById(employeeCode);
        if(this.repository.existsById(employeeCode)){
            return false;
        } else {
            return true;
        }
    }
}
