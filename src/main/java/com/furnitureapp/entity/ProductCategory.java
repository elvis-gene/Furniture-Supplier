package com.furnitureapp.entity;

public class ProductCategory {

    private int categoryCode;
    private String categoryName;

    private ProductCategory(Builder builder) {
        this.categoryCode = builder.categoryCode;
        this.categoryName = builder.categoryName;
    }

    public int getCategoryCode() {
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

    public static class Builder {
        private int categoryCode;
        private String categoryName;

        public Builder setCategoryCode(int categoryCode) {
            this.categoryCode = categoryCode;
            return this;
        }

        public Builder setCategoryName(String categoryName) {
            this.categoryName = categoryName;
            return this;
        }

        public Builder copy(ProductCategory productCategory){
            this.categoryCode = productCategory.categoryCode;
            this.categoryName = productCategory.categoryName;
            return this;
        }

        public ProductCategory build(){
            return new ProductCategory(this);
        }

    }
}
