package com.furnitureapp.factory.staff;

/*
 * @author: @yaseenjohnston
 * Description: Factory for Job entity
 */

import com.furnitureapp.entity.staff.Job;
import com.furnitureapp.utility.Helper;

public class JobFactory {

    public static Job createJob(String jobTitle, String jobDescription){

        return new Job.JobBuilder()
                .setJobCode(Helper.generateCode())
                .setJobTitle(jobTitle)
                .setJobDescription(jobDescription)
                .build();
    }
}
