package com.furnitureapp.repository.clientele.impl;
/*
 * @author: @nkosinathisola
 * Description: Appointment Repository
 */
import com.furnitureapp.entity.clientele.Appointment;
import com.furnitureapp.repository.clientele.AppointmentRepository;

import java.util.HashSet;
import java.util.Set;

public class AppointmentRepositoryImpl implements AppointmentRepository {

    private Set<Appointment> appointments;
    private static AppointmentRepository appointmentRepository = null;

    private AppointmentRepositoryImpl() {
        this.appointments = new HashSet<>();
    }

    public static AppointmentRepository getAppointmentRepository() {
        if (appointmentRepository == null) {
            appointmentRepository = new AppointmentRepositoryImpl();
        }
        return appointmentRepository;
    }

    @Override
    public Appointment create(Appointment appointment) {
        appointments.add(appointment);
        return appointment;
    }

    @Override
    public Appointment read(String customerName) {
        return this.appointments.stream()
                .filter(appointment -> appointment.getCustomerName()
                        .equals(customerName))
                .findAny()
                .orElse(null);
    }

    @Override
    public Appointment update(Appointment appointment) {
        Appointment existingAppointment = read(appointment.getCustomerName());
        if (existingAppointment != null) {
            appointments.remove(existingAppointment);
            appointments.add(appointment);
        }
        return appointment;
    }

    @Override
    public void delete(String customerName) {
        Appointment existingAppointment = read(customerName);
        if (existingAppointment != null) {
            appointments.remove(existingAppointment);
        }
    }

    @Override
    public Set<Appointment> list() {
        return appointments;
    }
}