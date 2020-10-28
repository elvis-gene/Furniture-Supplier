package com.furnitureapp.repository.staff;

import com.furnitureapp.entity.staff.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
