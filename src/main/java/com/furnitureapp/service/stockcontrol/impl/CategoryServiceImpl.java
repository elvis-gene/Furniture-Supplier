package com.furnitureapp.service.stockcontrol.impl;

import com.furnitureapp.entity.stockcontrol.Category;
import com.furnitureapp.repository.stockcontrol.CategoryRepository;
import com.furnitureapp.service.stockcontrol.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.stream.Collectors;

@Service

public class CategoryServiceImpl implements CategoryService {

    private static CategoryService categoryService = null;

    @Autowired
    private CategoryRepository repository;

    @Override
    public Set<Category> list() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Category create(Category category) {
        return this.repository.save(category);
    }

    @Override
    public Category read(Integer integer) {
        return this.repository.findById(integer).orElseGet(null);
    }

    @Override
    public Category update(Category category) {
        return this.repository.save(category);
    }

    @Override
    public boolean delete(Integer integer) {
        this.repository.deleteById(integer);
        if (this.repository.existsById(integer)) return false;
        else return true;
    }
}
