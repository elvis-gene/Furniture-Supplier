package com.furnitureapp.factory.distribution;
/*
 * @author: @munashemagidi
 * Description: Factory for Delivery entity
 */

import com.furnitureapp.entity.distribution.Delivery;
import  com.furnitureapp.utility.Helper;

public class DeliveryFactory {


    public static Delivery createDelivery(int saleCode,int employeeCode,String deliveryAddress,String dateTimeReceived, String dateTimeSet,int trackingNum, String deliveryStatus){
        Delivery delivery = new Delivery.DeliveryBuilder()

                .setDeliveryCode(Helper.generateCode())
                .setSaleCode(saleCode)
                .setEmployeeCode(employeeCode)
                .setDeliveryAddress(deliveryAddress)
                .setDateTimeReceived(dateTimeReceived)
                .setDateTimeSet(dateTimeSet)
                .setTrackingNum(trackingNum)
                .setDeliveryStatus(deliveryStatus)
                .build();

                return delivery;





    }

}
