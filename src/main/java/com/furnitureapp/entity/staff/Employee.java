package com.furnitureapp.entity.staff;

/*
 * @author: @yaseenjohnston
 * Description: Entity for Employee
 */

public class Employee {


    private int employeeCode;
    private String fullName;
    private String address;
    private String emailAddress;
    private String phone;
    private String shift;
    private double salary;
    private String passCode;
    private Job job;


    private Employee(EmployeeBuilder builder) {
        this.employeeCode = builder.employeeCode;
        this.fullName = builder.fullName;
        this.address = builder.address;
        this.emailAddress = builder.emailAddress;
        this.phone = builder.phone;
        this.shift = builder.shift;
        this.salary = builder.salary;
        this.passCode = builder.passCode;
        this.job = builder.job;
    }

    public int getEmployeeCode() {
        return employeeCode;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhone() {
        return phone;
    }

    public String getShift() {
        return shift;
    }

    public double getSalary() {
        return salary;
    }

    public String getPassCode(){
        return passCode;
    }

    public Job getJob(){
        return job;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeCode='" + employeeCode + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phone=" + phone +
                ", job=" + job +
                '}';
    }

    public static class EmployeeBuilder{
        private int employeeCode;
        private String fullName;
        private String address;
        private String emailAddress;
        private String phone;
        private String shift;
        private double salary;
        private String passCode;
        private Job job;

        public EmployeeBuilder() {
        }

        public EmployeeBuilder setEmployeeCode(int employeeCode) {
            this.employeeCode = employeeCode;
            return this;
        }

        public EmployeeBuilder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public EmployeeBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public EmployeeBuilder setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public EmployeeBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public EmployeeBuilder setShift(String shift) {
            this.shift = shift;
            return this;
        }

        public EmployeeBuilder setSalary(double salary) {
            this.salary = salary;
            return this;
        }

        public EmployeeBuilder setPassCode(String passCode){
            this.passCode = passCode;
            return this;
        }

        public EmployeeBuilder setJob(Job job){
            this.job = job;
            return this;
        }

        public EmployeeBuilder copy(Employee employee){
            this.employeeCode = employee.employeeCode;
            this.fullName = employee.fullName;
            this.address = employee.address;
            this.emailAddress = employee.emailAddress;
            this.phone = employee.phone;
            this.shift = employee.shift;
            this.salary = employee.salary;
            this.passCode = employee.passCode;
            this.job = employee.job;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }

}
