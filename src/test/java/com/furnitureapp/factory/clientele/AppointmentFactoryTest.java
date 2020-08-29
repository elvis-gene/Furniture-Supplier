package com.furnitureapp.factory.clientele;

import com.furnitureapp.entity.clientele.Appointment;
import com.furnitureapp.factory.clientele.AppointmentFactory;
import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.assertNotSame;

public class AppointmentFactoryTest {
    @Test
    public void createCustomer(){
        Appointment app1 = AppointmentFactory.createAppointment("Nkosinathi Sola"
                , "Annual Quality Inspection");

        Appointment app2 = AppointmentFactory.createAppointment("Sola Nkosinathi"
                ,"Customer Product Returns");

        assertNotSame(app2, app1);
    }
}
