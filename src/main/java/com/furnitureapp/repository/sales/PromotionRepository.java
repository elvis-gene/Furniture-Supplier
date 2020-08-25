package com.furnitureapp.repository.sales;

import com.furnitureapp.entity.sales.Promotion;
import com.furnitureapp.repository.IRepository;

// Identified by the promotion title, Second type to be a String.
public interface PromotionRepository extends IRepository<Promotion, String> {
}
