package com.furnitureapp.entity.stockcontrol;


import sun.security.provider.certpath.Builder;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class ProductProductCategory {

    @Id
    private Integer productCode;
    private Integer categoryCode;

    protected ProductProductCategory(){}

    private ProductProductCategory (Builder builder){
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
        return "ProductProductCategory{" +
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

        public Builder copy (ProductProductCategory productProductCategory){
            this.productCode = productProductCategory.productCode;
            this.categoryCode = productProductCategory.categoryCode;
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
