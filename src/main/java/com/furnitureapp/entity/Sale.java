package com.furnitureapp.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Sale{
    private int saleCode;
    private double totAmt;
    private String saleTime;

    private Sale(SaleBuilder builder){
        this.saleCode = builder.saleCode;
        this.totAmt = builder.totAmt;
        this.saleTime = builder.saleTime;
    }

    public int getSaleCode() { return saleCode; }

    public double getTotAmt() { return totAmt;  }

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
                ", totAmt=" + totAmt +
                ", saleTime='" + saleTime + '\'' +
                '}';
    }

    public static class SaleBuilder{
        private int saleCode;
        private double totAmt;
        private String saleTime;

        public SaleBuilder setSaleCode(int saleCode) {
            this.saleCode = saleCode;
            return this;
        }

        public SaleBuilder setTotAmt(double totAmt) {
            this.totAmt = totAmt;
            return this;
        }

        public SaleBuilder setSaleTime(String saleTime) {
            this.saleTime = saleTime;
            return this;
        }

        public SaleBuilder copy(Sale sale){
            this.saleCode = sale.saleCode;
            this.totAmt = sale.totAmt;
            this.saleTime= sale.saleTime;
            return this;
        }

        public Sale build(){
            return new Sale(this);
        }
    }

}
