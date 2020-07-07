package com.furnitureapp.factory.staff;

import com.furnitureapp.entity.staff.Job;
import com.furnitureapp.factory.staff.JobFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class JobFactoryTest {

    @Test
    public void createJob(){
        Job job1 = JobFactory.createJob("Clerk", "I work with stock and manipulating stock levels");
        Job job2 = JobFactory.createJob("Accountant", "I manage the finances of the company");


        //assertEquals(job, JobFactory.createJob("Clerk", "I work with stock and manipulating stock levels"));
        assertNotSame(job2, job1);


    }

}