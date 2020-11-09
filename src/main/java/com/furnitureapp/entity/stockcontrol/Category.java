package com.furnitureapp.entity.stockcontrol;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @author @Siba182
 * Description: Entity for ProductCatergory
 */

@Entity
public class Category {

    @Id
    private Integer categoryCode;
    private String categoryName;

    protected Category(){}

    private Category(CategoryBuilder builder) {
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
        return "Category{" +
                "categoryCode=" + categoryCode +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }

    public static class CategoryBuilder {
        private Integer categoryCode;
        private String categoryName;

        public CategoryBuilder setCategoryCode(Integer categoryCode) {
            this.categoryCode = categoryCode;
            return this;
        }

        public CategoryBuilder setCategoryName(String categoryName) {
            this.categoryName = categoryName;
            return this;
        }

        public CategoryBuilder copy(Category category){
            this.categoryCode = category.categoryCode;
            this.categoryName = category.categoryName;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CategoryBuilder that = (CategoryBuilder) o;
            return categoryCode.equals(that.categoryCode);
        }

        @Override
        public int hashCode() {
            return Objects.hash(categoryCode);
        }

        public Category build(){

            return new Category(this);
        }

    }
}
