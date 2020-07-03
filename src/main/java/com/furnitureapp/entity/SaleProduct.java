package com.furnitureapp.entity;

public class SaleProduct {
    private int saleCode;
    private int prodCode;
    private int quantity;

    public SaleProduct(SaleProductBuilder builder) {
        this.saleCode = builder.saleCode;
        this.prodCode = builder.prodCode;
        this.quantity = builder.quantity;
    }

    public int getSaleCode() {
        return saleCode;
    }

    public int getProdCode() {
        return prodCode;
    }

    public int getQuantity() {
        return quantity;
    }


    public static class SaleProductBuilder{
        private int saleCode;
        private int prodCode;
        private int quantity;

        public SaleProductBuilder setSaleCode(int saleCode) {
            this.saleCode = saleCode;
            return this;
        }

        public SaleProductBuilder setProdCode(int prodCode) {
            this.prodCode = prodCode;
            return this;
        }

        public SaleProductBuilder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public SaleProductBuilder copy(SaleProduct saleProduct){
            this.saleCode = saleProduct.saleCode;
            this.prodCode = saleProduct.prodCode;
            this.quantity = saleProduct.quantity;
            return this;
        }

        public SaleProduct build(){
            return new SaleProduct(this);
        }
    }
}
