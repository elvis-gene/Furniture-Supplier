package com.furnitureapp.entity.sales;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SaleProductCode implements Serializable {
    @Column(name = "sale_code")
    private Integer saleCode;
    @Column(name = "product_code")
    private Integer prodCode;

    public SaleProductCode() {}

    public SaleProductCode(Integer saleCode, Integer prodCode) {
        this.saleCode = saleCode;
        this.prodCode = prodCode;
    }

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

    @Override
    public String toString() {
        return "SaleProductCode{" +
                "saleCode=" + saleCode +
                ", prodCode=" + prodCode +
                '}';
    }
}
