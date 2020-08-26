package com.furnitureapp.repository.staff.impl;

import com.furnitureapp.entity.staff.Job;
import com.furnitureapp.repository.staff.JobRepository;

import java.util.HashSet;
import java.util.Set;

public class JobRepositorySQLImpl implements JobRepository {

    private static JobRepository jobRepository = null;

    private JobRepositorySQLImpl() {
        //Link to MySql database server
    }

    public static JobRepository getJobRepository(){
        if(jobRepository == null){
            jobRepository = new JobRepositorySQLImpl();
        }
        return jobRepository;
    }
    @Override
    public Job create(Job job) {
        return null;
    }

    @Override
    public Job read(Long jobCode) {
        return null;
    }

    @Override
    public Job update(Job job) {
        return null;
    }

    @Override
    public void delete(Long jobCode) {

    }

    @Override
    public Set<Job> list() {
        return null;
    }
}
