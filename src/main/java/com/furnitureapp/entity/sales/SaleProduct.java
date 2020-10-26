/*
    Coder: Elvis Gene
    Description: SaleProduct class. A sale might have more than one item and an item might exist in many sales
                    so this class serves as a bridge class whose objects will be unique to a sale.
 */

//Alternatives:
//        https://www.baeldung.com/jpa-many-to-many

package com.furnitureapp.entity.sales;

import javax.persistence.*;

@Entity(name = "sale_products")
@IdClass(SaleProductCode.class)
public class SaleProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer saleCode;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer prodCode;
    private int quantity;

    public SaleProduct(){}

    protected SaleProduct(Builder builder) {
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
        private int quantity;

        public Builder(){}

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder copy(SaleProduct saleProduct){
            this.quantity = saleProduct.quantity;
            return this;
        }

        public SaleProduct build(){
            return new SaleProduct(this);
        }
    }
}
