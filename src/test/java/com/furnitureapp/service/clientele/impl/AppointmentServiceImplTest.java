package com.furnitureapp.service.clientele.impl;
/*
 * @author: @nkosinathisola
 * Description: Appointment Service Impl Tests
 */
import com.furnitureapp.entity.clientele.Appointment;
import com.furnitureapp.factory.clientele.AppointmentFactory;
import com.furnitureapp.service.clientele.AppointmentService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import java.util.Set;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppointmentServiceImplTest {
    private static AppointmentService service = AppointmentServiceImpl.getAppointmentService();
    private static Appointment appointment = AppointmentFactory.createAppointment("Nkosinathi Sola", "Customer Returns");

    @Test
    public void a_create_appointment() {
        Appointment created = service.create(appointment);
        assertEquals(created, appointment);
        System.out.println("Create: " + created);
    }

    @Test
    public void b_read_appointment() {
        Appointment read = service.read(appointment.getCustomerName());
        assertEquals(appointment.getCustomerName(), read.getCustomerName());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update_appointment() {
        Appointment updated = new Appointment.AppointmentBuilder().copy(appointment).setCustomerName("Isaac Isaacs").build();
        updated = service.update(updated);
        assertNotEquals(updated, appointment);
        System.out.println("Update: " + updated);
    }

    @Test
    public void d_delete_appointment() {
        boolean deleted = service.delete(appointment.getCustomerName());
        assertTrue(deleted);
        System.out.println("Appointment deleted: " + deleted);
    }

    @Test
    public void list() {
        Set<Appointment> appointments = service.list();
        assertEquals(0, appointments.size());
    }
}
