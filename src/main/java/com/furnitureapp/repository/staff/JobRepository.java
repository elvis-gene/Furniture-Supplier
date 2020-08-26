package com.furnitureapp.repository.staff;

import com.furnitureapp.entity.staff.Job;
import com.furnitureapp.repository.IRepository;

import java.util.Set;

public interface JobRepository extends IRepository<Job, Long> {

    Job create(Job job);
    Job read(Long jobCode);
    Job update(Job job);
    void delete(Long jobCode);
    Set<Job> list();
}
