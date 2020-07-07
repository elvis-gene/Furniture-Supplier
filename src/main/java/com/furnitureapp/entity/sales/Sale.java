/*
    Coder: Elvis Gene
    Description: Sale class. Will be used once a sale is made.
 */

package com.furnitureapp.entity.sales;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Sale{
    private int saleCode;
    private double totalAmount;
    private String saleTime;

    private Sale(SaleBuilder builder){
        this.saleCode = builder.saleCode;
        this.totalAmount = builder.totalAmount;
        this.saleTime = builder.saleTime;
    }

    public int getSaleCode() { return saleCode; }

    public double getTotalAmount() { return totalAmount;  }

    public String getSaleTime() {
        //SimpleDateFormat will be used on the receipt to show the time of the transaction
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        saleTime = sdf.format(now);
        return saleTime;
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
        private int saleCode;
        private double totalAmount;
        private String saleTime;

        public SaleBuilder(){}

        public SaleBuilder setSaleCode(int saleCode) {
            this.saleCode = saleCode;
            return this;
        }

        public SaleBuilder setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public SaleBuilder setSaleTime(String saleTime) {
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
