/*
    Coder: Elvis Gene
    Description: Sale class. Will be used once a sale is made.
 */

package com.furnitureapp.entity.sales;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "sales")
public class Sale{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sale_code")
    private Integer saleCode;
    @Column(name = "total_amount")
    private double totalAmount;
    @Column(name = "sale_time")
    private LocalDateTime saleTime;

    public Sale(){}

    protected Sale(SaleBuilder builder){
        this.totalAmount = builder.totalAmount;
        this.saleTime = builder.saleTime;
    }

    public Integer getSaleCode() { return saleCode; }

    public double getTotalAmount() { return totalAmount;  }

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

        public SaleBuilder(){}

        public SaleBuilder setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public SaleBuilder setSaleTime(LocalDateTime saleTime) {
            this.saleTime = saleTime;
            return this;
        }

        public SaleBuilder copy(Sale sale){
            this.totalAmount = sale.totalAmount;
            this.saleTime= sale.saleTime;
            return this;
        }

        public Sale build(){
            return new Sale(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return saleCode.equals(sale.saleCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(saleCode);
    }
}
