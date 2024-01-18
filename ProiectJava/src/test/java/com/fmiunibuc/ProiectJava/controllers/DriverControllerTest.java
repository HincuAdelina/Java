package com.fmiunibuc.ProiectJava.controllers;

import com.fmiunibuc.ProiectJava.controllers.DriverController;
import com.fmiunibuc.ProiectJava.entities.Driver;
import com.fmiunibuc.ProiectJava.services.DriverService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DriverControllerTest {

    @Mock
    private DriverService driverService;

    @InjectMocks
    private DriverController driverController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getDriversByRestaurantIdTest() {
        int restaurantId = 1;
        when(driverService.getDriversByRestaurantId(restaurantId)).thenReturn(Arrays.asList(new Driver("James", "0743961256")));

        ResponseEntity<List<Driver>> response = driverController.getDriversByRestaurantId(restaurantId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals("James", response.getBody().get(0).getName());

        verify(driverService, times(1)).getDriversByRestaurantId(restaurantId);
    }

    @Test
    public void addDriverTest() {
        int restaurantId = 1;
        Driver driver = new Driver("James", "0743961256");
        when(driverService.addDriver(driver, restaurantId)).thenReturn(driver);

        ResponseEntity<Driver> response = driverController.addDriver(driver, restaurantId);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(driver, response.getBody());

        verify(driverService, times(1)).addDriver(driver, restaurantId);
    }

//    @Test
//    public void updateDriverTest() {
//        int driverId = 1;
//        Driver driver = new Driver("James", "0743961256");
//        Driver updatedDriver = new Driver("John", "0743961256");
//        when(driverService.updateDriver(driverId, updatedDriver)).thenReturn(updatedDriver);
//        when(driverService.getDriverById(driverId)).thenReturn(updatedDriver);
//
//        ResponseEntity<Driver> response = driverController.updateDriver(driverId, updatedDriver);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(updatedDriver, response.getBody());
//
//        verify(driverService, times(1)).updateDriver(driverId, updatedDriver);
//    }

    @Test
    public void removeDriverTest() {
        int driverId = 1;
        ResponseEntity<HttpStatus> response = driverController.removeDriver(driverId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

        verify(driverService, times(1)).removeDriver(driverId);
    }
}
