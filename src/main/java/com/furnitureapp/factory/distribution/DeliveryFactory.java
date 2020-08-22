package com.furnitureapp.factory.distribution;
/*
 * @author: @munashemagidi
 * Description: Factory for Delivery entity
 */

import com.furnitureapp.entity.distribution.Delivery;
import  com.furnitureapp.utility.Helper;

import java.time.LocalDateTime;

public class DeliveryFactory {

    public static Delivery createDelivery(int saleCode,int employeeCode,String deliveryAddress,int trackingNum, String deliveryStatus){

        return new Delivery.DeliveryBuilder()

                .setDeliveryCode(Helper.generateCode())
                .setSaleCode(saleCode)
                .setEmployeeCode(employeeCode)
                .setDeliveryAddress(deliveryAddress)
                .setDateTimeReceived(LocalDateTime.now())
                .setDateTimeSet(LocalDateTime.now())
                .setTrackingNum(trackingNum)
                .setDeliveryStatus(deliveryStatus)
                .build();





    }

}
