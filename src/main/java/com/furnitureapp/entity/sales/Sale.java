/*
    Coder: Elvis Gene
    Description: Sale class. Will be used once a sale is made.
 */

package com.furnitureapp.entity.sales;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "sales")
public class Sale{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer saleCode;
    private double totalAmount;
    private LocalDateTime saleTime;

//    @OneToMany(mappedBy = "sales")
//    Set<SaleProduct> products;

    public Sale(){}

    protected Sale(SaleBuilder builder){
        this.totalAmount = builder.totalAmount;
        this.saleTime = builder.saleTime;
//        this.products = builder.products;
    }

    public Integer getSaleCode() { return saleCode; }

    public double getTotalAmount() { return totalAmount;  }

//    public Set<SaleProduct> getProducts() {
//        return products;
//    }

    public LocalDateTime getSaleTime() {
        return LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Sale{" +
                "saleCode=" + saleCode +
                ", totAmt=" + totalAmount +
                ", saleTime='" + saleTime + '\'' +
                '}';
    }

    public static class SaleBuilder{
        private double totalAmount;
        private LocalDateTime saleTime;

//        @OneToMany(mappedBy = "sales")
//        private Set<SaleProduct> products;

        public SaleBuilder(){}

        public SaleBuilder setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public SaleBuilder setSaleTime(LocalDateTime saleTime) {
            this.saleTime = saleTime;
            return this;
        }

//        public SaleBuilder setProducts(Set<SaleProduct> products) {
//            this.products = products;
//            return this;
//        }

        public SaleBuilder copy(Sale sale){
            this.totalAmount = sale.totalAmount;
            this.saleTime= sale.saleTime;
//            this.products = sale.products;
            return this;
        }

        public Sale build(){
            return new Sale(this);
        }
    }

}
