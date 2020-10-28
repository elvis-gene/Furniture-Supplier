package com.furnitureapp.entity.stockcontrol;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StockCategory {
    @Id
    private Integer prodCatCode;
    private Integer categoryCode;

    protected StockCategory() {}

    protected StockCategory(Builder builder){

    }

    public Integer getProdCatCode() {
        return prodCatCode;
    }

    public Integer getCategoryCode() {
        return categoryCode;
    }

    public static class Builder{
        private Integer prodCatCode;
        private Integer categoryCode;

        public Builder setProdCatCode(Integer prodCatCode) {
            this.prodCatCode = prodCatCode;
            return this;
        }

        public Builder setCategoryCode(Integer categoryCode) {
            this.categoryCode = categoryCode;
            return this;
        }

        public Builder copy(StockCategory stockCategory){
            this.prodCatCode = stockCategory.prodCatCode;
            this.categoryCode = stockCategory.categoryCode;
            return this;
        }

        public StockCategory build(){
            return new StockCategory(this);
        }
    }
}
