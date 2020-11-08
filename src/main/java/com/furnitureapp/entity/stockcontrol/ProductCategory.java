package com.furnitureapp.entity.stockcontrol;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class ProductCategory {

    @Id
    private Integer productCode;
    private Integer categoryCode;

    protected ProductCategory(){}

    private ProductCategory(Builder builder){
        this.productCode = builder.productCode;
        this.categoryCode = builder.categoryCode;

    }

    public Integer getProductCode() {
        return productCode;
    }

    public Integer getCategoryCode() {
        return categoryCode;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "productCode=" + productCode +
                ", categoryCode=" + categoryCode +
                '}';
    }

    public class Builder {

        private Integer productCode, categoryCode;

        public Builder setProductCode (Integer productCode ){
            this.productCode = productCode;
            return this;

        }

        public Builder setCategoryCode (Integer categoryCode ){
            this.categoryCode = categoryCode;
            return this;

        }

        public Builder copy (ProductCategory productCategory){
            this.productCode = productCategory.productCode;
            this.categoryCode = productCategory.categoryCode;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return productCode.equals(builder.productCode) &&
                    categoryCode.equals(builder.categoryCode);
        }

        @Override
        public int hashCode() {
            return Objects.hash(productCode, categoryCode);
        }
    }
}
