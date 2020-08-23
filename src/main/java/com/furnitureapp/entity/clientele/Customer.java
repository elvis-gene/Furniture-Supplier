package com.furnitureapp.entity.clientele;

/*
 * @author: @nkosinathisola
 * Description: Customer Entity
 */

public class Customer{
    private Long customerCode;
    private String fullName;
    private String emailAddress;
    private String phoneNumber;
    private String address;
    private String password;
    private Appointment appointment;


    private Customer(CustomerBuilder customerBuilder){
        this.customerCode = customerBuilder.customerCode;
        this.address = customerBuilder.address;
        this.appointment = customerBuilder.appointment;
        this.emailAddress = customerBuilder.emailAddress;
        this.fullName = customerBuilder.fullName;
        this.phoneNumber = customerBuilder.phoneNumber;
        this.password = customerBuilder.password;
    }

    public Long getCustomerCode() {
        return customerCode;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerCode=" + customerCode +
                ", fullName='" + fullName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", appointment=" + appointment +
                '}';
    }

    public static class CustomerBuilder{
        private Long customerCode;
        private String fullName;
        private String emailAddress;
        private String phoneNumber;
        private String address;
        private String password;
        private Appointment appointment;

        public CustomerBuilder setCustomerCode(Long customerCode) {
            this.customerCode = customerCode;
            return this;
        }

        public CustomerBuilder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public CustomerBuilder setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public CustomerBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public CustomerBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public CustomerBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public CustomerBuilder setAppointment(Appointment appointment) {
            this.appointment = appointment;
            return this;
        }

        public CustomerBuilder copy(Customer customer){
            this.customerCode = customer.customerCode;
            this.fullName = customer.fullName;
            this.address = customer.address;
            this.appointment = customer.appointment;
            this.emailAddress = customer.emailAddress;
            this.password = customer.password;
            this.phoneNumber = customer.phoneNumber;
            return this;
        }

        public Customer build(){
            return new Customer(this);
        }
    }
}
