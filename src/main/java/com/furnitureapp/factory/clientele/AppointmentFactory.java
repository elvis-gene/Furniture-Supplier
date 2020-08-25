package com.furnitureapp.factory.clientele;

import com.furnitureapp.entity.clientele.Appointment;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentFactory {
    public static Appointment createAppointment(String customerName, String reason){
        return new Appointment.AppointmentBuilder()
                .setDate(LocalDate.now())
                .setCustomerName(customerName)
                .setTime(LocalTime.now())
                .setReason(reason)
                .build();
    }
}
