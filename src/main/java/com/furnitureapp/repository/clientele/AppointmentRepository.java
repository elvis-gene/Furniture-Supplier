package com.furnitureapp.repository.clientele;

import com.furnitureapp.entity.clientele.Appointment;
import com.furnitureapp.repository.IRepository;

import java.util.Set;

public interface AppointmentRepository extends IRepository<Appointment, String> {

    Appointment create(Appointment appointment);
    Appointment read(String customerName);
    Appointment update(Appointment appointment);
    void delete(Appointment appointment);
    Set<Appointment> list();

}
