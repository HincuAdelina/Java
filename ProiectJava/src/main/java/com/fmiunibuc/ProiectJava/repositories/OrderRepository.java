package com.fmiunibuc.ProiectJava.repositories;


import com.fmiunibuc.ProiectJava.entities.Order;
import com.fmiunibuc.ProiectJava.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findAllByRestaurantId(int restaurantId);
    List<Order> findAllByUserId(int restaurantId);
    List<Order> findAllByDriverId(int restaurantId);
}
