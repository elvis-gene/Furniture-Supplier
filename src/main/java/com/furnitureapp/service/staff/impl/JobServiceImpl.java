package com.furnitureapp.service.staff.impl;

/*
 * @author: @yaseenjohnston
 * Description: Implementation for Job Service
 */

import com.furnitureapp.entity.staff.Job;
import com.furnitureapp.repository.staff.JobRepository;
import com.furnitureapp.service.staff.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository repository;

    @Override
    public Set<Job> list() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Job create(Job job) {
        return this.repository.save(job);
    }

    @Override
    public Job read(Integer jobCode) {
        return this.repository.findById(jobCode).orElseGet(null);
    }

    @Override
    public Job update(Job job) {
        return create(job);
    }

    @Override
    public boolean delete(Integer jobCode) {
        this.repository.deleteById(jobCode);
        if(this.repository.existsById(jobCode)){
            return false;
        } else {
            return true;
        }
    }
}
