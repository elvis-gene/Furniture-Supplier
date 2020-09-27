package com.furnitureapp.service.staff.impl;

/*
 * @author: @yaseenjohnston
 * Description: Implementation for Job Service
 */

import com.furnitureapp.entity.staff.Job;
import com.furnitureapp.repository.staff.JobRepository;
import com.furnitureapp.repository.staff.impl.JobRepositoryImpl;
import com.furnitureapp.service.staff.JobService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class JobServiceImpl implements JobService {

    private JobRepository repository;
    private static JobService jobService = null;

    private JobServiceImpl() {
        this.repository = JobRepositoryImpl.getJobRepository();
    }

    public static JobService getJobService(){
        if(jobService == null){
            jobService = new JobServiceImpl();
        }
        return jobService;
    }

    @Override
    public Set<Job> list() {
        return this.repository.list();
    }

    @Override
    public Job create(Job job) {
        return this.repository.create(job);
    }

    @Override
    public Job read(Integer jobCode) {
        return this.repository.read(jobCode);
    }

    @Override
    public Job update(Job job) {
        return this.repository.update(job);
    }

    @Override
    public boolean delete(Integer jobCode) {
        return this.repository.delete(jobCode);
    }
}
