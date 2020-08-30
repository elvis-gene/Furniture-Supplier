package com.furnitureapp.entity.stockcontrol;

/**
 * @author @Siba182
 * Description: Entity for product
 */


public class Product {
    private Integer productCode;
    private String name;
    private double price;
    private float length;
    private float width;
    private float weight;
    private String description;
    private ProductCategory category;

    private Product(ProductBuilder builder) {
        this.productCode = builder.productCode;
        this.name = builder.name;
        this.price = builder.price;
        this.length = builder.length;
        this.width = builder.width;
        this.weight = builder.weight;
        this.description = builder.description;
        this.category = builder.category;

    }

    public Integer getProductCode() {
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

    public static class ProductBuilder {
        private Integer productCode;
        private String name;
        private double price;
        private float length;
        private float width;
        private float weight;
        private String description;
        private ProductCategory category;

        public ProductBuilder() {

        }


        public ProductBuilder setProductCode(Integer productCode) {
            this.productCode = productCode;
            return this;
        }

        public ProductBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder setPrice(double price) {
            this.price = price;
            return this;
        }

        public ProductBuilder setLength(float length) {
            this.length = length;
            return this;
        }

        public ProductBuilder setWidth(float width) {
            this.width = width;
            return this;

        }

        public ProductBuilder setWeight(float weight) {
            this.weight = weight;
            return this;

        }

        public ProductBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public ProductBuilder setCategory(ProductCategory category) {
            this.category = category;
            return this;
        }

        public ProductBuilder copy(Product product) {
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
