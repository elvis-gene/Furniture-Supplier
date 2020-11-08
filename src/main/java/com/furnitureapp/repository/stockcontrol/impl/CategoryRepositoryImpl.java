//package com.furnitureapp.repository.stockcontrol.impl;
//
///**
// * @author @Siba182
// * Description: Implement of product category repository
// */
//
//import com.furnitureapp.entity.stockcontrol.Category;
//import com.furnitureapp.repository.stockcontrol.CategoryRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class ProductCategoryRepositoryImpl implements CategoryRepository {
//    private static CategoryRepository productCategoryRepository = null;
//    private Set<Category> productCategories;
//
//    public ProductCategoryRepositoryImpl() {
//        productCategories = new HashSet<>();
//    }
//
//    public static CategoryRepository getProductCategoryRepository() {
//        if (productCategoryRepository == null)
//            productCategoryRepository = new ProductCategoryRepositoryImpl();
//        return productCategoryRepository;
//    }
//
//    @Override
//    public Category create(Category productCategory) {
//        this.productCategories.add(productCategory);
//        return productCategory;
//    }
//
//    @Override
//    public Category read(Integer categoryCode) {
//        for (Category productCategory : this.productCategories) {
//            if (productCategory.getCategoryCode().equals(categoryCode))
//                return productCategory;
//        }
//        return null;
//    }
//
//    @Override
//    public Category update(Category productCategory) {
//        Category category = read(productCategory.getCategoryCode());
//        if (category != null) {
//            productCategories.remove(category);
//            productCategories.add(productCategory);
//        }
//        return productCategory;
//    }
//
//    @Override
//    public boolean delete(Integer categoryCode) {
//        boolean deleted = false;
//
//        Category category = read(categoryCode);
//        if (category != null) {
//            productCategories.remove(category);
//            deleted = true;
//        }
//        return deleted;
//    }
//
//    @Override
//    public Set<Category> list() {
//        return this.productCategories;
//    }
//}
