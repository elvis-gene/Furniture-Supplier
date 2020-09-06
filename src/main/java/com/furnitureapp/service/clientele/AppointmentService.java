package com.furnitureapp.service.clientele;

import com.furnitureapp.entity.clientele.Appointment;
import com.furnitureapp.service.IService;
import java.util.Set;

public interface AppointmentService extends IService<Appointment, String> {
    Set<Appointment> list();
}
