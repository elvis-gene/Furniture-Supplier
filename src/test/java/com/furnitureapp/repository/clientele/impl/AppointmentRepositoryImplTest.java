package com.furnitureapp.repository.clientele.impl;
/*
 * @author: @nkosinathisola
 * Description: Appointment Repository Impl Tests
 */
import com.furnitureapp.entity.clientele.Appointment;
import com.furnitureapp.factory.clientele.AppointmentFactory;
import com.furnitureapp.repository.clientele.AppointmentRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class AppointmentRepositoryImplTest{

    private static AppointmentRepository repo = AppointmentRepositoryImpl.getAppointmentRepository();
    private static Appointment appointment = AppointmentFactory.createAppointment("Nkosinathi Sola", "Customer Returns");

    @Test
    public void a_create_appointment() {
        Appointment created = repo.create(appointment);
        assertEquals(created, appointment);
        System.out.println("Create: " + created);
    }

    @Test
    public void b_read_appointment() {
        Appointment read = repo.read(appointment.getCustomerName());
        assertEquals(read.getCustomerName(), appointment.getCustomerName());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update_appointment() {
        Appointment updated = new Appointment.AppointmentBuilder().copy(appointment).setCustomerName("Emanuel Skye").build();
        updated = repo.update(updated);
        assertNotEquals(updated, appointment);
        System.out.println("Update: " + updated);
    }

    @Test
    public void d_delete_appointment() {
        boolean deleted = repo.delete(appointment.getCustomerName());
        assertTrue(deleted);
    }

    @Test
    public void list() {
        Set<Appointment> appointments = repo.list();
        assertEquals(0, appointments.size());
    }
}
