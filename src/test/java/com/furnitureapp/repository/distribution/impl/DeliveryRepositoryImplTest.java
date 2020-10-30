//package com.furnitureapp.repository.distribution.impl;
//
//import com.furnitureapp.entity.distribution.Delivery;
//import com.furnitureapp.factory.distribution.DeliveryFactory;
//import com.furnitureapp.repository.distribution.DeliveryRepository;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Set;
//
//import static org.junit.Assert.*;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//
//public class DeliveryRepositoryImplTest {
//
//    @Autowired
//    private  static DeliveryRepository repo;
//    private static  Delivery delivery = DeliveryFactory.createDelivery(123,456,"32 Dave Street"
//            ,789,"Delivered");
//
//    @Test
//    public void a_create() {
//        Delivery created = repo.create(delivery);
//        assertEquals(created, delivery);
//        System.out.println("Create: " + created);
//    }
//
//    @Test
//    public void b_read() {
//        Delivery read = repo.read(delivery.getDeliveryCode());
//        assertEquals(delivery.getDeliveryCode(), read.getDeliveryCode());
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    public void c_update() {
//        Delivery updated = new Delivery.DeliveryBuilder().copy(delivery).setDeliveryAddress("14 Money Way").build();
//        updated = repo.update(updated);
//        assertNotEquals(updated, delivery);
//        System.out.println("Update: " + updated);
//    }
//
//    @Test
//    public void d_delete() {
//        boolean deleted = repo.delete(delivery.getDeliveryCode());
//        assertTrue(deleted);
//    }
//
//    @Test
//    public void e_list() {
//        Set<Delivery> deliveries = repo.list();
//        assertEquals(0, deliveries.size());
//    }
//}
