package com.furnitureapp.factory;

import com.furnitureapp.entity.Appointment;
import org.junit.Test;

import static org.junit.Assert.assertNotSame;

public class AppointmentFactoryTest {
    @Test
    public void createCustomer(){
        Appointment app1 = AppointmentFactory.createAppointment("05-07-2020"
                , "Nkosinathi Sola"
                , "9:00"
                , "Annual Quality Inspection");

        Appointment app2 = AppointmentFactory.createAppointment("15-09-2020"
                ,"Sola Nkosinathi"
                ,"11:30"
                ,"Customer Product Returns");

        assertNotSame(app2, app1);
    }
}
