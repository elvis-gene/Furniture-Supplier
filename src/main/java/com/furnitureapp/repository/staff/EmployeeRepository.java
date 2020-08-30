package com.furnitureapp.repository.staff;

import com.furnitureapp.entity.staff.Employee;
import com.furnitureapp.repository.IRepository;

import java.util.Set;

public interface EmployeeRepository extends IRepository<Employee, Integer> {

    Set<Employee> list();
}
