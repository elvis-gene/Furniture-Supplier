package com.furnitureapp.entity.stockcontrol;

public class Stock {
    private Long prodCatCode;
    private int quantity;

    private Stock(StockBuilder stockBuilder){
        this.prodCatCode = stockBuilder.prodCatCode;
        this.quantity = stockBuilder.quantity;
    }

    public Long getProdCatCode() {
        return prodCatCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public static class StockBuilder{
        private Long prodCatCode;
        private int quantity;

        public StockBuilder setProdCatCode(Long prodCatCode) {
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
