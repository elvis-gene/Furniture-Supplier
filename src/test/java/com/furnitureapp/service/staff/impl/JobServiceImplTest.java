package com.furnitureapp.service.staff.impl;

import com.furnitureapp.entity.staff.Job;
import com.furnitureapp.factory.staff.JobFactory;
import com.furnitureapp.service.staff.JobService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JobServiceImplTest {

    private static JobService service = JobServiceImpl.getJobService();
    private static Job job = JobFactory.createJob("Software Engineer", "Develops and maintains software infrastructure");


    @Test
    public void list() {
        Set<Job> jobs = service.list();
        assertEquals(0, jobs.size());
        System.out.println("All Jobs: " + jobs);
    }

    @Test
    public void a_create() {
        Job created = service.create(job);
        assertEquals(job, created);
        System.out.println("Create: " + created);
    }

    @Test
    public void b_read() {
        Job read = service.read(job.getJobCode());
        assertEquals(job.getJobCode(), read.getJobCode());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        Job updated = new Job.JobBuilder().copy(job).setJobTitle("Front-End Engineer").build();
        updated = service.update(updated);
        assertNotEquals(updated.getJobTitle(), job.getJobTitle());
        System.out.println("Update: " + updated);
    }

    @Test
    public void d_delete() {
        boolean deleted = service.delete(job.getJobCode());
        assertTrue(deleted);
        System.out.println("Job deleted: " + deleted);
    }
}
