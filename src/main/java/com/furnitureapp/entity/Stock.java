package com.furnitureapp.entity;

public class Stock {
    private int prodCatCode;
    private int quantity;

    public Stock(StockBuilder stockBuilder){
        this.prodCatCode = stockBuilder.prodCatCode;
        this.quantity = stockBuilder.quantity;
    }

    public int getProdCatCode() {
        return prodCatCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public static class StockBuilder{
        private int prodCatCode;
        private int quantity;

        public StockBuilder setProdCatCode(int prodCatCode) {
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
