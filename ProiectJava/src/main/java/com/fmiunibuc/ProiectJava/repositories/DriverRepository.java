package com.fmiunibuc.ProiectJava.repositories;

import com.fmiunibuc.ProiectJava.entities.Driver;
import com.fmiunibuc.ProiectJava.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Integer> {

    List<Driver> findAllByRestaurantId(int restaurantId);
}
