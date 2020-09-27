package com.furnitureapp.entity.clientele;

/*
 * @author: @nkosinathisola
 * Description: Appointment Entity
 */

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    private String customerName;
    private LocalDate date;
    private LocalTime time;
    private String reason;

    private Appointment(AppointmentBuilder appointmentBuilder){
        this.date = appointmentBuilder.date;
        this.time = appointmentBuilder.time;
        this.reason = appointmentBuilder.reason;
        this.customerName = appointmentBuilder.customerName;
    }

    public Appointment(){

    }

    public String getCustomerName() {
        return customerName;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "customerName='" + customerName + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", reason='" + reason + '\'' +
                '}';
    }

    public static class AppointmentBuilder {

        public AppointmentBuilder() {}

        private LocalDate date;
        private LocalTime time;
        private String reason;
        private String customerName;

        public AppointmentBuilder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public AppointmentBuilder setTime(LocalTime time) {
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
