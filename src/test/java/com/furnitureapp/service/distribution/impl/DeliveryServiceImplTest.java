package com.furnitureapp.service.distribution.impl;

import static org.junit.Assert.*;

import com.furnitureapp.entity.distribution.Delivery;
import com.furnitureapp.factory.distribution.DeliveryFactory;
import com.furnitureapp.service.distribution.DeliveryService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class DeliveryServiceImplTest {

    private static DeliveryService service = DeliveryServiceImpl.getDeliveryService();
    private static Delivery delivery = DeliveryFactory.createDelivery(123,002,"15 Mas Street",1545,"Shipped");



    @Test
    public void a_create() {
        Delivery newDelivery = service.create(delivery);
        assertEquals(newDelivery, delivery);
        System.out.println("New Delivery: "+ newDelivery);
    }

    @Test
    public void b_read() {
        Delivery readDevelivery = service.read(delivery.getDeliveryCode());
        assertEquals(readDevelivery, delivery);
        System.out.println("Read " + readDevelivery);
    }

    @Test
    public void c_update() {
        Delivery updatedDelivery = new Delivery.DeliveryBuilder().copy(delivery).setDeliveryStatus("Shipped").build();
        updatedDelivery = service.update(updatedDelivery);
        assertNotEquals(delivery, updatedDelivery);
        System.out.println("Updated delivery: " + updatedDelivery);
    }




    @Test
    public void d_list() {
        Set<Delivery> deliveries = service.list();
        assertEquals(1, deliveries.size());
        System.out.println("All deliveries: "+ deliveries);
    }

    @Test
    public void e_delete() {
        boolean deleted = service.delete(delivery.getDeliveryCode());
        assertTrue(deleted);
        System.out.println("Delivery deleted: "+ Boolean.toString(deleted));
    }

}
