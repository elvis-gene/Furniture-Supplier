package com.furnitureapp.service.staff.impl;

/*
 * @author: @yaseenjohnston
 * Description: Implementation for EmployeeJob Service
 */

import com.furnitureapp.entity.staff.EmployeeJob;
import com.furnitureapp.repository.staff.EmployeeJobRepository;
import com.furnitureapp.service.staff.EmployeeJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeJobServiceImpl implements EmployeeJobService {

    @Autowired
    private EmployeeJobRepository repository;

    @Override
    public Set<EmployeeJob> list() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public EmployeeJob create(EmployeeJob employeeJob) {
        return this.repository.save(employeeJob);
    }

    @Override
    public EmployeeJob read(Integer employeeCode) {
        return this.repository.findById(employeeCode).orElseGet(null);
    }

    @Override
    public EmployeeJob update(EmployeeJob employeeJob) {
        return create(employeeJob);
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
