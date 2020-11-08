package com.furnitureapp.service.stockcontrol;

import com.furnitureapp.entity.stockcontrol.Category;
import com.furnitureapp.service.IService;

import java.util.Set;

public interface CategoryService extends IService <Category, Integer> {
    Set<Category> list();

}
