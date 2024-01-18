package com.fmiunibuc.ProiectJava.services;

import com.fmiunibuc.ProiectJava.entities.Order;
import com.fmiunibuc.ProiectJava.entities.Product;

import java.util.List;

public interface OrderService {

    List<Order> getOrdersByUserId(int userId);

    List<Order> getOrdersByRestaurantId(int restaurantId);

    List<Order> getOrdersByDriverId(int restaurantId);

    List<Product> getProductsByOrderId(int id);

    Order getOrderById(int id);

    Order addOrder(Order order, int restaurantId, int userId, int driverId);

    Order addProductToOrder(int id, int productId);

    Order removeProductFromOrder(int id, int productId);

    void updateOrder(int id, Order order);

    void removeOrder(int id);
}
