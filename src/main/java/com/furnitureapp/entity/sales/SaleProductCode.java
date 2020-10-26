package com.furnitureapp.entity.sales;

import java.io.Serializable;
import java.util.Objects;

public class SaleProductCode implements Serializable {
    private Integer saleCode, prodCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleProductCode that = (SaleProductCode) o;
        return saleCode.equals(that.saleCode) &&
                prodCode.equals(that.prodCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(saleCode, prodCode);
    }
}
