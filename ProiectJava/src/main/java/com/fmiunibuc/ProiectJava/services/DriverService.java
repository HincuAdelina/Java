package com.fmiunibuc.ProiectJava.services;

import com.fmiunibuc.ProiectJava.entities.Driver;
import com.fmiunibuc.ProiectJava.entities.Product;

import java.util.List;

public interface DriverService {

    Driver getDriverById(int id);
    List<Driver> getDriversByRestaurantId(int restaurantId);
    Driver addDriver(Driver driver, int restaurantId);
    void updateDriver(int id, Driver driver);

    void removeDriver(int id);
}
