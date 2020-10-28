package com.furnitureapp.repository.staff;

import com.furnitureapp.entity.staff.EmployeeJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeJobRepository extends JpaRepository<EmployeeJob, Integer> {

}
