package com.furnitureapp.controller.staff;

/*
 * @author: @yaseenjohnston
 * Description: Controller for Job
 */

import com.furnitureapp.entity.staff.Job;
import com.furnitureapp.factory.staff.JobFactory;
import com.furnitureapp.service.staff.impl.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/Job")
public class JobController {

    @Autowired
    private JobServiceImpl jobService;

    @GetMapping("/list")
    public Set<Job> list(){
        return jobService.list();
    }

    @PostMapping("/create")
    public Job create(@RequestBody Job job){
        Job newJob = JobFactory.createJob(job.getJobTitle(), job.getJobDescription());
        return jobService.create(newJob);
    }

    @GetMapping("/read/{jobCode}")
    public Job read(@PathVariable Integer jobCode){
        return jobService.read(jobCode);
    }

    @PostMapping("/update")
    public Job update(@RequestBody Job job){
        return jobService.update(job);
    }

    @DeleteMapping("/delete/{jobCode}")
    public boolean delete(@PathVariable Integer jobCode){
        return jobService.delete(jobCode);
    }
}

