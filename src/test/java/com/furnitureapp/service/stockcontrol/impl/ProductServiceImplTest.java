package com.furnitureapp.service.stockcontrol.impl;

import com.furnitureapp.entity.stockcontrol.Product;
import com.furnitureapp.factory.stockcontrol.ProductCategoryFactory;
import com.furnitureapp.factory.stockcontrol.ProductFactory;
import com.furnitureapp.service.stockcontrol.ProductService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class ProductServiceImplTest {

    private static ProductService productService = ProductServiceImpl.getProductService();
    private static Product product = ProductFactory.createProduct("Mattress", 2250.00, 137,
            183, 85, "This is a double bed",
            ProductCategoryFactory.createProductCategory("Beds and Mattresses"));

    @Test
    public void a_created() {
        Product created = productService.create(product);
        Assert.assertEquals(product.getProductCode(), created.getProductCode());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        Product read = productService.read(product.getProductCode());
        Assert.assertEquals(product.getProductCode(), read.getProductCode());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        Product updated = new Product.ProductBuilder().copy(product).setName("Bedroom Sets").build();
        updated = productService.update(updated);
        Assert.assertNotEquals(updated, product);
        System.out.println("Updated : " + updated);
    }

    @Test
    public void e_delete() {
        boolean deleted = productService.delete(product.getProductCode());
        Assert.assertTrue(deleted);
        System.out.println("Product name deleted: " + deleted);

    }

    @Test
    public void d_list() {
        Set<Product> products = productService.list();
        Assert.assertEquals(1, products.size());
        System.out.println("Product details: " + products);
    }
}
