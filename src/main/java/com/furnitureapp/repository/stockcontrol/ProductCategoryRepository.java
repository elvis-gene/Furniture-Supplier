package com.furnitureapp.repository.stockcontrol;

import com.furnitureapp.entity.stockcontrol.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
}
