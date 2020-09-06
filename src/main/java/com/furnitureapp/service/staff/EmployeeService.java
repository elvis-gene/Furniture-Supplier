package com.furnitureapp.service.staff;

import com.furnitureapp.entity.staff.Employee;
import com.furnitureapp.service.IService;

import java.util.Set;

public interface EmployeeService  extends IService<Employee, Integer> {

    Set<Employee> list();

}
