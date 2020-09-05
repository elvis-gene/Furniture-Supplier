package com.furnitureapp.service.staff;

import com.furnitureapp.entity.staff.Job;
import com.furnitureapp.service.IService;

import java.util.Set;

public interface JobService extends IService<Job, Integer> {

    Set<Job> list();

}
