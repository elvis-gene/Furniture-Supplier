package com.furnitureapp.service.clientele.impl;
/*
 * @author: @nkosinathisola
 * Description: Appointment Service Impl
 */
import com.furnitureapp.entity.clientele.Appointment;
import com.furnitureapp.repository.clientele.AppointmentRepository;
import com.furnitureapp.repository.clientele.impl.AppointmentRepositoryImpl;
import com.furnitureapp.service.clientele.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepository repository;
    private static AppointmentService appointmentService = null;

    private AppointmentServiceImpl() {
        this.repository = AppointmentRepositoryImpl.getAppointmentRepository();
    }

    public static AppointmentService getAppointmentService(){
        if(appointmentService == null){
            appointmentService = new AppointmentServiceImpl();
        }
        return appointmentService;
    }

    @Override
    public Appointment create(Appointment appointment)
    {
        return this.repository.create(appointment);
    }

    @Override
    public Appointment read(String customerName)
    {
        return this.repository.read(customerName);
    }

    @Override
    public Appointment update(Appointment appointment)
    {
        return this.repository.update(appointment);
    }

    @Override
    public boolean delete(String customerName)
    {
        return this.repository.delete(customerName);
    }

    @Override
    public Set<Appointment> list()
    {
        return this.repository.list();
    }
}