package com.furnitureapp.entity.staff;

/*
 * @author: @yaseenjohnston
 * Description: Entity for Employee
 */


import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Employee {

    @Id
    private Integer employeeCode;

    private String fullName;
    private String address;
    private String emailAddress;
    private String phone;
    private String shift;
    private double salary;
    private String passCode;

    protected Employee() {
    }

    private Employee(EmployeeBuilder builder) {
        this.employeeCode = builder.employeeCode;
        this.fullName = builder.fullName;
        this.address = builder.address;
        this.emailAddress = builder.emailAddress;
        this.phone = builder.phone;
        this.shift = builder.shift;
        this.salary = builder.salary;
        this.passCode = builder.passCode;
    }

    public Integer getEmployeeCode() {
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

    @Override
    public String toString() {
        return "Employee{" +
                "employeeCode='" + employeeCode + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phone=" + phone +
                '}';
    }

    public static class EmployeeBuilder{
        private Integer employeeCode;
        private String fullName;
        private String address;
        private String emailAddress;
        private String phone;
        private String shift;
        private double salary;
        private String passCode;

        public EmployeeBuilder() {
        }

        public EmployeeBuilder setEmployeeCode(Integer employeeCode) {
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


        public EmployeeBuilder copy(Employee employee){
            this.employeeCode = employee.employeeCode;
            this.fullName = employee.fullName;
            this.address = employee.address;
            this.emailAddress = employee.emailAddress;
            this.phone = employee.phone;
            this.shift = employee.shift;
            this.salary = employee.salary;
            this.passCode = employee.passCode;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeCode.equals(employee.employeeCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeCode);
    }
}
