package com.fmiunibuc.ProiectJava.services;

import com.fmiunibuc.ProiectJava.entities.Restaurant;

import java.util.List;

public interface RestaurantService {

    Restaurant getRestaurantById(int id);

    List<Restaurant> getRestaurantList();

    Restaurant addRestaurant(Restaurant restaurant);

    void updateRestaurant(int id, Restaurant restaurant);

    void removeRestaurant(int id);
}
