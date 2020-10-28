package com.furnitureapp.entity.distribution;

import java.io.Serializable;
import java.util.Objects;

public class EmployeeDelivery implements Serializable {
    private Integer employeeCode,deliveryCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDelivery that = (EmployeeDelivery) o;
        return employeeCode.equals(that.employeeCode) &&
                deliveryCode.equals(that.deliveryCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeCode, deliveryCode);
    }
}
