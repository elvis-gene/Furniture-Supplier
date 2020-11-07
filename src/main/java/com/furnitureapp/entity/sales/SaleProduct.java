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
//@IdClass(SaleProductCode.class)
public class SaleProduct {

    @EmbeddedId
    SaleProductCode id;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "sale_code")
//    private Integer saleCode;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "product_code")
//    private Integer prodCode;

    @Column
    private int quantity;

    public SaleProduct(){}

    protected SaleProduct(Builder builder) {
        this.quantity = builder.quantity;
        this.id = builder.id;
    }

    public SaleProductCode getId() {
        return id;
    }

    //
//    public Integer getSaleCode() {
//        return saleCode;
//    }
//
//    public Integer getProdCode() {
//        return prodCode;
//    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "SaleProduct{" +
                 id +
                ", quantity=" + quantity +
                '}';
    }

    public static class Builder{
        @EmbeddedId
        SaleProductCode id;

        private int quantity;

        public Builder(){}

        public Builder setId(SaleProductCode id) {
            this.id = id;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder copy(SaleProduct saleProduct){
            this.id = saleProduct.id;
            this.quantity = saleProduct.quantity;
            return this;
        }

        public SaleProduct build(){
            return new SaleProduct(this);
        }
    }
}
