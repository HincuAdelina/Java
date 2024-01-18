package com.fmiunibuc.ProiectJava.repositories;

import com.fmiunibuc.ProiectJava.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
}