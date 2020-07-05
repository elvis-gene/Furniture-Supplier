package com.furnitureapp.factory;

import com.furnitureapp.entity.Appointment;

public class AppointmentFactory {
    public static Appointment createAppointment(String date, String customerName, String time, String reason){
        return new Appointment.AppointmentBuilder()
                .setDate(date)
                .setCustomerName(customerName)
                .setTime(time)
                .setReason(reason)
                .build();
    }
}
