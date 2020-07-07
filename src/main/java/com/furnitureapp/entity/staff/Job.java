package com.furnitureapp.entity.staff;

/*
 * @author: @yaseenjohnston
 * Description: Entity for Job
 */

public class Job {

    private int jobCode;
    private String jobTitle;
    private String jobDescription;


    private Job(JobBuilder builder) {
        this.jobCode = builder.jobCode;
        this.jobTitle = builder.jobTitle;
        this.jobDescription = builder.jobDescription;
    }

    public int getJobCode() {
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
        private int jobCode;
        private String jobTitle;
        private String jobDescription;

        public JobBuilder() {
        }

        public JobBuilder setJobCode(int jobCode) {
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

}
