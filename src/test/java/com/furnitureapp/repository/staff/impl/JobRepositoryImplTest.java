package com.furnitureapp.repository.staff.impl;

import com.furnitureapp.entity.staff.Job;
import com.furnitureapp.factory.staff.JobFactory;
import com.furnitureapp.repository.staff.JobRepository;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class JobRepositoryImplTest {

    private static JobRepository repo = new JobRepositoryImpl();
    private static Job job = JobFactory.createJob("Software Engineer", "Develops and maintains software infrastructure");

    @Test
    public void create() {
        Job created = repo.create(job);
        assertEquals(job, created);
    }

    @Test
    public void read() {
        Job read = repo.read(job.getJobCode());
        assertEquals(job.getJobCode(), read.getJobCode());
    }

    @Test
    public void update() {
        Job updated = new Job.JobBuilder().copy(job).setJobCode((long) 465789).build();
        updated = repo.update(updated);
        assertNotEquals(updated.getJobCode(), job.getJobCode());
    }

    @Test
    public void delete() {
        repo.delete(job.getJobCode());
    }

    @Test
    public void list() {
        Set<Job> jobs = repo.list();
        assertEquals(0, jobs.size());
    }
}