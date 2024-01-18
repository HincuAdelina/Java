package com.fmiunibuc.ProiectJava.services;

import com.fmiunibuc.ProiectJava.entities.Product;
import com.fmiunibuc.ProiectJava.entities.Restaurant;

import java.util.List;

public interface ProductService {

    Product getProductById(int id);
    List<Product> getProductsByRestaurantId(int restaurantId);

    Product addProduct(Product product, int restaurantId);
    void updateProduct(int id, Product product);

    void removeProduct(int id);
}
