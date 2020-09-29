package com.furnitureapp.controller.clientele;
/*
 * @author: @nkosinathisola
 * Description: Appointment Controller
 */
import com.furnitureapp.entity.clientele.Appointment;
import com.furnitureapp.factory.clientele.AppointmentFactory;
import com.furnitureapp.service.clientele.impl.AppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentServiceImpl appointmentService;

    @GetMapping("/list")
    public Set<Appointment> list(){
        return appointmentService.list();
    }

    @PostMapping("/create")
    public Appointment create(@RequestBody Appointment appointment){
        Appointment newAppointment = AppointmentFactory.createAppointment(appointment.getCustomerName(), appointment.getReason());
        return appointmentService.create(newAppointment);
    }

    @GetMapping("/read/{customerName}")
    public Appointment read(@PathVariable String customerName){
        return appointmentService.read(customerName);
    }

    @PostMapping("/update")
    public Appointment update(@RequestBody Appointment appointment){
        return appointmentService.update(appointment);
    }

    @DeleteMapping("/delete/{customerName}")
    public boolean delete(@PathVariable String customerName){
        return appointmentService.delete(customerName);
    }

}