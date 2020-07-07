package com.furnitureapp.factory.distribution;

/*
 * @author: @munashemagidi
 * Description: Factory for Delivery entity
 */

import com.furnitureapp.entity.distribution.Delivery;
import com.furnitureapp.factory.distribution.DeliveryFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotSame;

public class DeliveryFactoryTest {

    @Test

    public void createDelivery(){
        Delivery d1 = DeliveryFactory.createDelivery(

                111,
                123,
                "55 Jesse Way",
                "05/07/2020 15:55",
                "03/07/2020 14:44",
                7856,
                "Complete");

        Delivery d2 = DeliveryFactory.createDelivery(
                777,
                321,
                "48 Dank Way",
                "05/06/2020 15:55",
                "03/05/2020 14:44",
                4568,
                "In-progress");

        assertNotSame(d2, d1);
    }
}
