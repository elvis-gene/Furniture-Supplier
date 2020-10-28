package com.furnitureapp.service.staff;

import com.furnitureapp.entity.staff.EmployeeJob;
import com.furnitureapp.service.IService;

import java.util.Set;

public interface EmployeeJobService extends IService<EmployeeJob, Integer> {

    Set<EmployeeJob> list();

}
