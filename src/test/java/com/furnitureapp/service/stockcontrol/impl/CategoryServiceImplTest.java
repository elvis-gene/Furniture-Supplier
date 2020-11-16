package com.furnitureapp.service.stockcontrol.impl;

import com.furnitureapp.entity.stockcontrol.Category;
import com.furnitureapp.factory.stockcontrol.CategoryFactory;
import com.furnitureapp.service.stockcontrol.CategoryService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;


 @FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CategoryServiceImplTest {

     @Autowired
     private CategoryService categoryService;
     private static Category category = CategoryFactory.createCategory
             ("Beds and Mattresses");

     @Test
     public void d_list() {
         Set<Category> categories = categoryService.list();
         Assert.assertEquals(1, categories.size());
         System.out.println(" Category details: " + categories);
     }

     @Test
     public void a_create() {
         Category created = categoryService.create(category);
         Assert.assertEquals(category.getCategoryCode(), created.getCategoryCode());
         System.out.println("Created: " + created);
     }

     @Test
     public void b_read() {
         Category read = categoryService.read(category.getCategoryCode());
         Assert.assertEquals(category.getCategoryCode(), read.getCategoryCode());
         System.out.println("Read: " + read);
     }

     @Test
     public void c_update() {
         Category updated = new Category.CategoryBuilder().copy(category).setCategoryName("Tables").build();
         updated = categoryService.update(updated);
         Assert.assertNotEquals(updated, category);
         System.out.println("Updated: " + updated);
     }

     @Test
     public void e_delete() {
         boolean deleted = categoryService.delete(category.getCategoryCode());
         Assert.assertTrue(deleted);
         System.out.println("Category name deleted: " + deleted);

     }
 }
