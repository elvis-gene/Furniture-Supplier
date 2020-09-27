/*
    Coder: Elvis Gene
    Description: SaleProduct class. A sale might have more than one item and an item might exist in many sales
                    so this class serves as a bridge class whose objects will be unique to a sale.
 */


package com.furnitureapp.entity.sales;

public class SaleProduct {
    private Integer saleCode;
    private Integer prodCode;
    private int quantity;

    private SaleProduct(){}

    private SaleProduct(Builder builder) {
        this.saleCode = builder.saleCode;
        this.prodCode = builder.prodCode;
        this.quantity = builder.quantity;
    }

    public Integer getSaleCode() {
        return saleCode;
    }

    public Integer getProdCode() {
        return prodCode;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "SaleProduct{" +
                "saleCode=" + saleCode +
                ", prodCode=" + prodCode +
                ", quantity=" + quantity +
                '}';
    }

    public static class Builder{
        private Integer saleCode;
        private Integer prodCode;
        private int quantity;

        public Builder(){}

        public Builder setSaleCode(Integer saleCode) {
            this.saleCode = saleCode;
            return this;
        }

        public Builder setProdCode(Integer prodCode) {
            this.prodCode = prodCode;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder copy(SaleProduct saleProduct){
            this.saleCode = saleProduct.saleCode;
            this.prodCode = saleProduct.prodCode;
            this.quantity = saleProduct.quantity;
            return this;
        }

        public SaleProduct build(){
            return new SaleProduct(this);
        }
    }
}
