package com.furnitureapp.factory;
/*
 * @author: @munashemagidi
 * Description: Factory for Delivery entity
 */

import com.furnitureapp.entity.Delivery;
import  com.furnitureapp.utility.Helper;

public class DeliveryFactory {


    public static Delivery createDelivery(int deliveryCode,int saleCode,int employeeCode,String deliveryAddress,String dateTimeReceived, String dateTimeSet,int trackingNum, boolean deliveryStatus){
        Delivery delivery = new Delivery.DeliveryBuilder()

                .setDeliveryCode(Helper.generateCode())
                .setSaleCode(saleCode)
                .setEmployeeCode(Helper.generateCode())
                .setDeliveryAddress(deliveryAddress)
                .setDateTimeReceived(dateTimeReceived)
                .setDateTimeSet(dateTimeSet)
                .setTrackingNum(trackingNum)
                .setDeliveryStatus(deliveryStatus)
                .build();

                return delivery;




    }

}
