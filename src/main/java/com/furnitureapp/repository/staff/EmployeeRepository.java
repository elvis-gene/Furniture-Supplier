package com.furnitureapp.repository.staff;

import com.furnitureapp.entity.staff.Employee;
import com.furnitureapp.repository.IRepository;

import java.util.Set;

public interface EmployeeRepository extends IRepository<Employee, Long> {

    Employee create(Employee employee);
    Employee read(Long employeeCode);
    Employee update(Employee employee);
    void delete(Long employeeCode);
    Set<Employee> list();
}
