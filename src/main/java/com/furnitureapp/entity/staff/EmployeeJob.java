package com.furnitureapp.entity.staff;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class EmployeeJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeCode;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobCode;

    protected EmployeeJob(){}

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

        /*public Builder employeeCode(Integer employeeCode){
            this.employeeCode = employeeCode;
            return this;
        }

        public Builder jobCode(Integer jobCode){
            this.jobCode = jobCode;
            return this;
        }*/

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeJob that = (EmployeeJob) o;
        return employeeCode.equals(that.employeeCode) &&
                jobCode.equals(that.jobCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeCode, jobCode);
    }
}
