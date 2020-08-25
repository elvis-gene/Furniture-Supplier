/*
    Coder: Elvis Gene
    Description: Sale class. Will be used once a sale is made.
 */

package com.furnitureapp.entity.sales;
import java.time.LocalDateTime;


public class Sale{
    private Long saleCode;
    private double totalAmount;
    private LocalDateTime saleTime;

    private Sale(SaleBuilder builder){
        this.saleCode = builder.saleCode;
        this.totalAmount = builder.totalAmount;
        this.saleTime = builder.saleTime;
    }

    public Long getSaleCode() { return saleCode; }

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
        private Long saleCode;
        private double totalAmount;
        private LocalDateTime saleTime;

        public SaleBuilder(){}

        public SaleBuilder setSaleCode(Long saleCode) {
            this.saleCode = saleCode;
            return this;
        }

        public SaleBuilder setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public SaleBuilder setSaleTime(LocalDateTime saleTime) {
            this.saleTime = saleTime;
            return this;
        }

        public SaleBuilder copy(Sale sale){
            this.saleCode = sale.saleCode;
            this.totalAmount = sale.totalAmount;
            this.saleTime= sale.saleTime;
            return this;
        }

        public Sale build(){
            return new Sale(this);
        }
    }

}
