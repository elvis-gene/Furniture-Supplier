package com.furnitureapp.entity.stockcontrol;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @author @Siba182
 * Description: Entity for ProductCatergory
 */

@Entity
public class ProductCategory {

    @Id
    private Integer categoryCode;
    private String categoryName;

    protected ProductCategory (){}

    private ProductCategory(ProductCategoryBuilder builder) {
        this.categoryCode = builder.categoryCode;
        this.categoryName = builder.categoryName;
    }

    public Integer getCategoryCode() {
        return categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "categoryCode=" + categoryCode +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }

    public static class ProductCategoryBuilder {
        private Integer categoryCode;
        private String categoryName;

        public ProductCategoryBuilder setCategoryCode(Integer categoryCode) {
            this.categoryCode = categoryCode;
            return this;
        }

        public ProductCategoryBuilder setCategoryName(String categoryName) {
            this.categoryName = categoryName;
            return this;
        }

        public ProductCategoryBuilder copy(ProductCategory productCategory){
            this.categoryCode = productCategory.categoryCode;
            this.categoryName = productCategory.categoryName;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ProductCategoryBuilder that = (ProductCategoryBuilder) o;
            return categoryCode.equals(that.categoryCode);
        }

        @Override
        public int hashCode() {
            return Objects.hash(categoryCode);
        }

        public ProductCategory build(){

            return new ProductCategory(this);
        }

    }
}
