package com.furnitureapp.service.clientele.impl;
/*
 * @author: @nkosinathisola
 * Description: Appointment Service Impl
 */
import com.furnitureapp.entity.clientele.Appointment;
import com.furnitureapp.repository.clientele.AppointmentRepository;
import com.furnitureapp.service.clientele.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    @Override
    public Appointment create(Appointment appointment)
    {
        return this.repository.save(appointment);
    }

    @Override
    public Appointment read(String customerName)
    {
        return this.repository.findById(customerName).orElse(null);
    }

    @Override
    public Appointment update(Appointment appointment)
    {
        return create(appointment);
    }

    @Override
    public boolean delete(String customerName)
    {
        this.repository.deleteById(customerName);
        if(this.repository.existsById(customerName)) return false;
        return true;
    }

    @Override
    public Set<Appointment> list()
    {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}