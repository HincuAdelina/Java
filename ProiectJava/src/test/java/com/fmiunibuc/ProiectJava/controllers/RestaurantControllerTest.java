package com.fmiunibuc.ProiectJava.controllers;

import com.fmiunibuc.ProiectJava.controllers.RestaurantController;
import com.fmiunibuc.ProiectJava.entities.Restaurant;
import com.fmiunibuc.ProiectJava.services.RestaurantService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RestaurantControllerTest {

    @Mock
    private RestaurantService restaurantService;

    @InjectMocks
    private RestaurantController restaurantController;

    @Test
    public void getRestaurantByIdTest() {
        int restaurantId = 1;
        when(restaurantService.getRestaurantById(restaurantId)).thenReturn(new Restaurant("McDonald's", "Main Street", "09:00 - 22:00"));

        ResponseEntity<Restaurant> response = restaurantController.getRestaurant(restaurantId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("McDonald's", response.getBody().getName());
    }


    @Test
    public void getRestaurantListTest() {
        when(restaurantService.getRestaurantList()).thenReturn(Arrays.asList(
                new Restaurant("McDonald's", "Main Street", "09:00 - 22:00"),
                new Restaurant("Pizza Hut", "First Avenue", "10:00 - 23:00")
        ));

        ResponseEntity<List<Restaurant>> response = restaurantController.getRestaurantList();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
    }

//    @Test
//    public void updateRestaurantTest() {
//        int restaurantId = 1;
//        Restaurant updatedRestaurant = new Restaurant("Updated McDonald's", "New Street", "09:00 - 23:00");
//        when(restaurantService.getRestaurantById(restaurantId)).thenReturn(new Restaurant("McDonald's", "Main Street", "09:00 - 22:00"));
//
//        ResponseEntity<Restaurant> response = restaurantController.updateRestaurant(restaurantId, updatedRestaurant);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(updatedRestaurant.getName(), response.getBody().getName());
//    }


    @Test
    public void addRestaurantTest() {
        Restaurant newRestaurant = new Restaurant("KFC", "Second Street", "10:00 - 21:00");
        when(restaurantService.addRestaurant(newRestaurant)).thenReturn(newRestaurant);

        ResponseEntity<Restaurant> response = restaurantController.addRestaurant(newRestaurant);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(newRestaurant.getName(), response.getBody().getName());
    }

    @Test
    public void removeRestaurantTest() {
        int restaurantId = 1;

        doNothing().when(restaurantService).removeRestaurant(restaurantId);

        ResponseEntity<HttpStatus> response = restaurantController.removeRestaurant(restaurantId);

        verify(restaurantService, times(1)).removeRestaurant(restaurantId);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

}
