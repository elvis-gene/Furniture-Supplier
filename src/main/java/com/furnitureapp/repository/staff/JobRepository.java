package com.furnitureapp.repository.staff;

import com.furnitureapp.entity.staff.Job;
import com.furnitureapp.repository.IRepository;

import java.util.Set;

public interface JobRepository extends IRepository<Job, Integer> {

    Set<Job> list();
}
