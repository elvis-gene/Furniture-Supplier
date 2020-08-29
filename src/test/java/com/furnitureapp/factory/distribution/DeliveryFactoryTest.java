package com.furnitureapp.factory.distribution;

/*
 * @author: @munashemagidi
 * Description: Factory for Delivery entity
 */

import com.furnitureapp.entity.distribution.Delivery;
import com.furnitureapp.factory.distribution.DeliveryFactory;
import com.furnitureapp.utility.Helper;
import org.junit.Test;

import static org.junit.Assert.assertNotSame;

public class DeliveryFactoryTest {

    @Test
    public void createDelivery(){
        Delivery d1 = DeliveryFactory.createDelivery(

                Helper.generateCode(),
                Helper.generateCode(),
                "55 Jesse Way",
                7856,
                "Complete");

        Delivery d2 = DeliveryFactory.createDelivery(
                Helper.generateCode(),
                Helper.generateCode(),
                "48 Dank Way",
                4568,
                "In-progress");

        assertNotSame(d2, d1);
    }
}
