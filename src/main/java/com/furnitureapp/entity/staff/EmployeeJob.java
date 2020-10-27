package com.furnitureapp.entity.staff;

public class EmployeeJob {

    private Integer employeeCode, jobCode;

    private EmployeeJob(){}

    private EmployeeJob(Builder builder){
        this.employeeCode = builder.employeeCode;
        this.jobCode = builder.jobCode;
    }

    public Integer getEmployeeCode() {
        return employeeCode;
    }

    public Integer getJobCode() {
        return jobCode;
    }

    public static class Builder{
        private Integer employeeCode, jobCode;

        public Builder employeeCode(Integer employeeCode){
            this.employeeCode = employeeCode;
            return this;
        }

        public Builder jobCode(Integer jobCode){
            this.jobCode = jobCode;
            return this;
        }

        public Builder copy(EmployeeJob employeeJob){
            this.employeeCode = employeeJob.employeeCode;
            this.jobCode = employeeJob.jobCode;
            return this;
        }

        public EmployeeJob build() {
            return new EmployeeJob(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "employeeCode=" + employeeCode +
                    ", jobCode=" + jobCode +
                    '}';
        }
    }
}
