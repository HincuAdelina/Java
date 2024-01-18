package com.fmiunibuc.ProiectJava.repositories;

import com.fmiunibuc.ProiectJava.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllByRestaurantId(int restaurantId);
}
