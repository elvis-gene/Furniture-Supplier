package com.furnitureapp.repository.staff.impl;
/*
 * @author: @yaseenjohnston
 * Description: Repository for Job
 */

import com.furnitureapp.entity.staff.Job;
import com.furnitureapp.repository.staff.JobRepository;

import java.util.HashSet;
import java.util.Set;

public class JobRepositoryImpl implements JobRepository {

    private Set<Job> jobs;
    private static JobRepository jobRepository = null;

    public JobRepositoryImpl() {
        this.jobs = new HashSet<>();
    }

    public static JobRepository getJobRepository(){
        if(jobRepository == null){
            jobRepository = new JobRepositoryImpl();
        }
        return jobRepository;
    }

    @Override
    public Job create(Job job){
        jobs.add(job);
        return job;
    }

    @Override
    public Job read(Integer jobCode){
        return this.jobs.stream().filter(sale -> sale.getJobCode().equals(jobCode)).
                findAny().orElse(null);
    }

    @Override
    public Job update(Job job){
        Job existingJob = read(job.getJobCode());
        if(existingJob != null){
            jobs.remove(existingJob);
            jobs.add(job);
        }

        return job;
    }

    @Override
    public boolean delete(Integer jobCode){
      boolean deleted = false;

      Job existingJob = read(jobCode);
      if(existingJob != null){
          jobs.remove(existingJob);
          deleted = true;
      }
      return deleted;
    }

    @Override
    public Set<Job> list() {
        return jobs;
    }
}
