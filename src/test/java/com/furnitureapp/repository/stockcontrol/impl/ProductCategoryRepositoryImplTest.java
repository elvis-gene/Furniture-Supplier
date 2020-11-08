//package com.furnitureapp.repository.stockcontrol.impl;
//
///**
// * @author @Siba182
// * Description: Test implementing product category
// */
//
//import com.furnitureapp.entity.stockcontrol.Category;
//import com.furnitureapp.factory.stockcontrol.ProductCategoryFactory;
//import com.furnitureapp.repository.stockcontrol.ProductCategoryRepository;
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Set;
//
//import static org.junit.Assert.*;
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//
//public class ProductCategoryRepositoryImplTest {
//
//    @Autowired
//    private static ProductCategoryRepository productCategoryRepository;
//    private static Category category = ProductCategoryFactory.createProductCategory("Beds and Mattresses");
//
//
//    @Test
//    public void a_create() {
//        Category created = productCategoryRepository.create(category);
//        Assert.assertEquals(created, category);
//        System.out.println("Created: " + created);
//    }
//
//    @Test
//    public void b_read() {
//        Category read = productCategoryRepository.read(category.getCategoryCode());
//        Assert.assertEquals(category.getCategoryCode(), read.getCategoryCode());
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    public void c_update() {
//        Category updated = new Category.ProductCategoryBuilder().copy(category).setCategoryCode(2654).build();
//        updated = productCategoryRepository.update(updated);
//        Assert.assertNotEquals(updated, category);
//        System.out.println("Updated: " + updated);
//    }
//
//    @Test
//    public void e_delete() {
//       boolean deleted = productCategoryRepository.delete(category.getCategoryCode());
//        Assert.assertTrue(deleted);
//    }
//
//    @Test
//    public void d_list() {
//        Set<Category> productCategories = productCategoryRepository.list();
//        Assert.assertNotEquals(1, productCategories.size());
//
//    }
//
//}
