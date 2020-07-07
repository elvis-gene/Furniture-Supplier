package com.furnitureapp.entity.clientele;

/*
 * @author: @nkosinathisola
 * Description: Appointment Entity
 */

public class Appointment {
    private String date;
    private String customerName;
    private String time;
    private String reason;

    private Appointment(AppointmentBuilder appointmentBuilder){
        this.date = appointmentBuilder.date;
        this.time = appointmentBuilder.time;
        this.reason = appointmentBuilder.reason;
        this.customerName = appointmentBuilder.customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getReason() {
        return reason;
    }


    public static class AppointmentBuilder {

        public AppointmentBuilder() {}

        private String date;
        private String time;
        private String reason;
        private String customerName;

        public AppointmentBuilder setDate(String date) {
            this.date = date;
            return this;
        }

        public AppointmentBuilder setTime(String time) {
            this.time = time;
            return this;
        }

        public AppointmentBuilder setReason(String reason) {
            this.reason = reason;
            return this;
        }

        public AppointmentBuilder setCustomerName(String customerName){
            this.customerName = customerName;
            return this;
        }

        public  AppointmentBuilder copy (Appointment app){
            this.date = app.date;
            this.time = app.time;
            this.reason = app.reason;
            this.customerName = app.customerName;
            return this;
        }

        public Appointment build() {
            return new Appointment(this);
        }
    }
}
