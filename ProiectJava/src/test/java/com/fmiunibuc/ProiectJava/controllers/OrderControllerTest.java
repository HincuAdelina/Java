package com.fmiunibuc.ProiectJava.controllers;

import com.fmiunibuc.ProiectJava.entities.Order;
import com.fmiunibuc.ProiectJava.entities.Product;
import com.fmiunibuc.ProiectJava.services.OrderService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getOrdersByRestaurantIdTest() {
        int restaurantId = 1;
        when(orderService.getOrdersByRestaurantId(restaurantId)).thenReturn(Arrays.asList(
                new Order(Timestamp.valueOf("2023-01-03 00:00:00"), 50, 20, "In Progress")
        ));

        ResponseEntity<List<Order>> response = orderController.getOrdersByRestaurantId(restaurantId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals(50, response.getBody().get(0).getTotalprice());
        assertEquals("In Progress", response.getBody().get(0).getStatus());

        verify(orderService, times(1)).getOrdersByRestaurantId(restaurantId);
    }

    @Test
    public void addOrderTest() {
        int restaurantId = 1;
        int userId = 2;
        int driverId = 3;
        Order order = new Order(Timestamp.valueOf("2023-01-03 00:00:00"), 50, 20, "In Progress");

        when(orderService.addOrder(order, restaurantId, userId, driverId)).thenReturn(order);

        ResponseEntity<Order> response = orderController.addOrder(order, restaurantId, userId, driverId);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(order, response.getBody());

        verify(orderService, times(1)).addOrder(order, restaurantId, userId, driverId);
    }

    @Test
    public void getProductsByOrderIdTest() {
        int orderId = 1;
        when(orderService.getProductsByOrderId(orderId)).thenReturn(Arrays.asList(
                new Product("Iaurt", "150g - fructe", 5, "lactate")
        ));

        ResponseEntity<List<Product>> response = orderController.getProductsByOrderId(orderId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals("Iaurt", response.getBody().get(0).getName());

        verify(orderService, times(1)).getProductsByOrderId(orderId);
    }

    @Test
    public void removeProductFromOrderTest() {
        int orderId = 1;
        int productId = 2;

        ResponseEntity<Order> response = orderController.removeProductFromOrder(orderId, productId);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        verify(orderService, times(1)).removeProductFromOrder(orderId, productId);
    }


    @Test
    public void updateOrderTest() {
        int orderId = 1;
        Order updatedOrder = new Order(Timestamp.valueOf("2022-12-22 00:00:00"), 100, 60, "Delivered");

        ResponseEntity<Order> response = orderController.updateOrder(orderId, updatedOrder);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        verify(orderService, times(1)).updateOrder(orderId, updatedOrder);
    }




}
