package com.furnitureapp.entity;

public class Product {

    private int productCode;
    private String name;
    private double price;
    private float length;
    private float width;
    private float weight;
    private String description;
    private ProductCategory category;

    private Product(Builder builder) {
        this.productCode = builder.productCode;
        this.name = builder.name;
        this.price = builder.price;
        this.length = builder.length;
        this.width = builder.width;
        this.weight = builder.weight;
        this.description = builder.description;
        this.category = builder.category;

    }

    public int getProductCode() {
        return productCode;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public float getLength() {
        return length;
    }

    public float getWidth() {
        return width;
    }

    public float getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }

    public ProductCategory getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode=" + productCode +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", length=" + length +
                ", width=" + width +
                ", weight=" + weight +
                ", description='" + description + '\'' +
                ", category=" + category +
                '}';
    }

    public static class Builder {
        private int productCode;
        private String name;
        private double price;
        private float length;
        private float width;
        private float weight;
        private String description;
        private ProductCategory category;


        public Builder setProductCode(int productCode) {
            this.productCode = productCode;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setLength(float length) {
            this.length = length;
            return this;
        }

        public Builder setWidth(float width) {
            this.width = width;
            return this;

        }

        public Builder setWeight(float weight) {
            this.weight = weight;
            return this;

        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setCategory(ProductCategory category) {
            this.category = category;
            return this;
        }

        public Builder copy(Product product) {
            this.productCode = product.productCode;
            this.name = product.name;
            this.price = product.price;
            this.length = product.length;
            this.width = product.width;
            this.weight = product.weight;
            this.description = product.description;
            this.category = product.category;
            return this;
        }

        public Product build() {
            return new Product(this);
        }

    }
}
