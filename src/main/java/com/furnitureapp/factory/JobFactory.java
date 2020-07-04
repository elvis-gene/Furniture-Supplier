package com.furnitureapp.factory;

/*
 * @author: @yaseenjohnston
 * Description: Factory for Job entity
 */

import com.furnitureapp.entity.Job;
import com.furnitureapp.utility.Helper;

public class JobFactory {

    public static Job createJob(String jobTitle, String jobDescription){

        Job job = new Job.JobBuilder()
                .setJobCode(Helper.generateCode())
                .setJobTitle(jobTitle)
                .setJobDescription(jobDescription)
                .build();
        return job;
    }

}
