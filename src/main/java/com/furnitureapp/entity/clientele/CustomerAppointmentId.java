package com.furnitureapp.entity.clientele;

import java.io.Serializable;
import java.util.Objects;

public class CustomerAppointmentId implements Serializable {
    private Integer customerCode, customerName;

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        CustomerAppointmentId that = (CustomerAppointmentId) o;
        return customerCode.equals(that.customerCode) &&
                customerName.equals(that.customerName);
    }

    @Override
    public int hashCode(){
        return Objects.hash(customerCode, customerName);
    }
}
