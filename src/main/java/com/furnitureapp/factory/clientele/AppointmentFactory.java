package com.furnitureapp.factory.clientele;

import com.furnitureapp.entity.clientele.Appointment;

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
