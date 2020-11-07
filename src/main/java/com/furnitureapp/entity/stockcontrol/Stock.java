package com.furnitureapp.entity.stockcontrol;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Stock {
    @Id
    private Integer prodCatCode;
    private int quantity;

    protected Stock(){}
    protected Stock(StockBuilder stockBuilder){
        this.prodCatCode = stockBuilder.prodCatCode;
        this.quantity = stockBuilder.quantity;
    }

    public Integer getProdCatCode() {
        return prodCatCode;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "prodCatCode=" + prodCatCode +
                ", quantity=" + quantity +
                '}';
    }

    public int getQuantity() {
        return quantity;
    }

    public static class StockBuilder{
        private Integer prodCatCode;
        private int quantity;

        public StockBuilder setProdCatCode(Integer prodCatCode) {
            this.prodCatCode = prodCatCode;
            return this;
        }

        public StockBuilder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public StockBuilder copy(Stock stock){
            this.prodCatCode = stock.prodCatCode;
            this.quantity = stock.quantity;
            return this;
        }

        public Stock build(){
            return new Stock(this);
        }
    }
}
