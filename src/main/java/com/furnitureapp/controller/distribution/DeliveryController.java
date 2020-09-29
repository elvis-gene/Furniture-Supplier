package com.furnitureapp.controller.distribution;

import com.furnitureapp.entity.distribution.Delivery;
import com.furnitureapp.factory.distribution.DeliveryFactory;
import com.furnitureapp.service.distribution.impl.DeliveryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryServiceImpl deliveryService;

    @PostMapping("/create")
    public Delivery create(@RequestBody Delivery delivery){
        //    Delivery newDelivery = DeliveryFactory.createDelivery(delivery.getSaleCode(), delivery.getEmployeeCode(), delivery.getDeliveryAddress(), delivery.getTrackingNum(), "delivery.getStatus");
        return deliveryService.create(delivery);
    }

    @GetMapping("/read/{deliveryCode}")
    public Delivery read(@PathVariable Integer deliveryCode){return deliveryService.read(deliveryCode);}

    @PostMapping("/update")
    public Delivery update(@RequestBody Delivery delivery){return deliveryService.update(delivery);}

    @DeleteMapping("/delete/{deliveryCode}")
    public boolean delete(@PathVariable Integer deliveryCode){return deliveryService.delete(deliveryCode);}

    @GetMapping("/list")
    public Set<Delivery> list(){
        return deliveryService.list();
    }

    // @GetMapping("/delivery_status")
    //public  <Set> Delivery checkDeliveryStatus(){
    //  return deliveryService.getDeliveryStatus();
    //}
    //@GetMapping("/delivery_status")
    //private Delivery checkDeliveryStatus(String deliveryStatus){
    //  return deliveryService.getDeliveryStatus(deliveryStatus);
    //}

}
