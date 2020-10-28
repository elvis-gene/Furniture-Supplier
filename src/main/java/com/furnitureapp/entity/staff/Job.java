package com.furnitureapp.entity.staff;

/*
 * @author: @yaseenjohnston
 * Description: Entity for Job
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Job {

    @Id
    private Integer jobCode;

    private String jobTitle;
    private String jobDescription;

    protected Job() {
    }

    private Job(JobBuilder builder) {
        this.jobCode = builder.jobCode;
        this.jobTitle = builder.jobTitle;
        this.jobDescription = builder.jobDescription;
    }

    public Integer getJobCode() {
        return jobCode;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }


    @Override
    public String toString() {
        return "Job{" +
                "jobCode=" + jobCode +
                ", jobTitle='" + jobTitle + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                '}';
    }

    public static class JobBuilder{
        private Integer jobCode;
        private String jobTitle;
        private String jobDescription;

        public JobBuilder() {
        }

        public JobBuilder setJobCode(Integer jobCode) {
            this.jobCode = jobCode;
            return this;
        }

        public JobBuilder setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
            return this;
        }

        public JobBuilder setJobDescription(String jobDescription) {
            this.jobDescription = jobDescription;
            return this;
        }

        public JobBuilder copy(Job job){
            this.jobCode = job.jobCode;
            this.jobTitle = job.jobTitle;
            this.jobDescription = job.jobDescription;
            return this;
        }

        public Job build(){
            return new Job(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return jobCode.equals(job.jobCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobCode);
    }
}
