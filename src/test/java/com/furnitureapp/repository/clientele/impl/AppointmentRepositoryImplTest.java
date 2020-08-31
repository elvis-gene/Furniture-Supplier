package com.furnitureapp.repository.clientele.impl;
/*
 * @author: @nkosinathisola
 * Description: Appointment Repository Impl Tests
 */
import com.furnitureapp.entity.clientele.Appointment;
import com.furnitureapp.factory.clientele.AppointmentFactory;
import com.furnitureapp.repository.clientele.AppointmentRepository;
import junit.framework.TestCase;
import org.junit.Test;
import java.util.Set;
import static org.junit.Assert.assertNotEquals;

public class AppointmentRepositoryImplTest extends TestCase{

    private static AppointmentRepository repo = AppointmentRepositoryImpl.getAppointmentRepository();
    private static Appointment appointment = AppointmentFactory.createAppointment("Nkosinathi Sola", "Customer Returns");

    @Test
    public void create_appointment() {
        Appointment created = repo.create(appointment);
        assertEquals(created, appointment);
        System.out.println("Create: " + created);
    }

    @Test
    public void read_appointment() {
        Appointment read = repo.read(appointment.getCustomerName());
        assertEquals(read.getCustomerName(), appointment.getCustomerName());
        System.out.println("Read: " + read);
    }

    @Test
    public void update_appointment() {
        Appointment updated = new Appointment.AppointmentBuilder().copy(appointment).setCustomerName("Emanuel Skye").build();
        updated = repo.update(updated);
        assertNotEquals(updated, appointment);
        System.out.println("Update: " + updated);
    }

    @Test
    public void delete_appointment() {
        repo.delete(appointment.getCustomerName());
        System.out.println("Appointment Deleted");
    }

    @Test
    public void list() {
        Set<Appointment> appointments = repo.list();
        assertEquals(0, appointments.size());
    }
}