package com.furnitureapp.repository.stockcontrol;

import com.furnitureapp.entity.stockcontrol.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductCategoryRepository extends JpaRepository<Category, Integer> {
}
