package com.furnitureapp.entity.sales;

import java.util.Objects;

public class CartSaleProduct {
    private  Integer cartNum, saleProductCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartSaleProduct that = (CartSaleProduct) o;
        return cartNum.equals(that.cartNum) &&
                saleProductCode.equals(that.saleProductCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartNum, saleProductCode);
    }
}
