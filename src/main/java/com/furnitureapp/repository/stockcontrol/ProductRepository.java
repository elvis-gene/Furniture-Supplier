package com.furnitureapp.repository.stockcontrol;

import com.furnitureapp.entity.stockcontrol.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface ProductRepository extends JpaRepository <Product, Integer>{}

