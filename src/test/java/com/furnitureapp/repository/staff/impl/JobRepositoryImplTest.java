package com.furnitureapp.repository.staff.impl;

import com.furnitureapp.entity.staff.Job;
import com.furnitureapp.factory.staff.JobFactory;
import com.furnitureapp.repository.staff.JobRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JobRepositoryImplTest {

    private static JobRepository repo = new JobRepositoryImpl();
    private static Job job = JobFactory.createJob("Software Engineer", "Develops and maintains software infrastructure");

    @Test
    public void a_create() {
        Job created = repo.create(job);
        assertEquals(job, created);
        System.out.println("Create: " + created);
    }

    @Test
    public void b_read() {
        Job read = repo.read(job.getJobCode());
        assertEquals(job.getJobCode(), read.getJobCode());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        Job updated = new Job.JobBuilder().copy(job).setJobTitle("Front-End Engineer").build();
        updated = repo.update(updated);
        assertNotEquals(updated.getJobTitle(), job.getJobTitle());
        System.out.println("Update: " + updated);
    }

    @Test
    public void d_delete() {
        repo.delete(job.getJobCode());
        System.out.println("Job deleted");
    }

    @Test
    public void e_list() {
        Set<Job> jobs = repo.list();
        assertEquals(0, jobs.size());
    }
}