package com.fmiunibuc.ProiectJava.services;

import com.fmiunibuc.ProiectJava.entities.Driver;
import com.fmiunibuc.ProiectJava.entities.Restaurant;
import com.fmiunibuc.ProiectJava.repositories.DriverRepository;
import com.fmiunibuc.ProiectJava.repositories.RestaurantRepository;
import com.fmiunibuc.ProiectJava.services.DriverService;
import com.fmiunibuc.ProiectJava.services.impl.DriverServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DriverServiceTest {

    @Mock
    private DriverRepository driverRepository;

    @Mock
    private RestaurantRepository restaurantRepository;

    @InjectMocks
    private DriverServiceImpl driverService;

    @Test
    public void getDriverByIdTest() {
        Driver driver = new Driver("James", "0743961256");
        int id = driver.getId();
        when(driverRepository.findById(id)).thenReturn(Optional.of(driver));

        Driver result = driverService.getDriverById(id);

        assertEquals(driver, result);

    }

    @Test
    public void getDriversByRestaurantTest() {
        Restaurant restaurant = new Restaurant("BurgerKing", "Strada 1", "Non-Stop");
        int id = restaurant.getId();
        when(driverRepository.findAllByRestaurantId(id)).thenReturn(Arrays.asList(new Driver("James", "0743961256")));

        List<Driver> result = driverService.getDriversByRestaurantId(id);

        assertEquals("James", result.get(0).getName());
    }

    @Test
    public void addDriverTest() {
        Restaurant restaurant = new Restaurant("BurgerKing", "Strada 1", "Non-Stop");
        int id = restaurant.getId();
        Driver driver = new Driver("James", "0743961256");
        when(restaurantRepository.findById(id)).thenReturn(Optional.of(restaurant));

        driverService.addDriver(driver, id);

        verify(driverRepository, times(1)).save(driver);

    }

    @Test
    public void updateDriverTest() {
        Driver driver = new Driver("James", "0743961256");
        Driver driverUpdated = new Driver("John", "0743961256");
        int id = driverUpdated.getId();
        when(driverRepository.findById(id)).thenReturn(Optional.of(driver));

        driverService.updateDriver(id, driver);

        verify(driverRepository, times(1)).save(driver);

    }

    @Test
    public void removeDriverTest() {
        Driver driver = new Driver("James", "0743961256");
        int id = driver.getId();

        driverService.removeDriver(id);

        verify(driverRepository, times(1)).deleteById(id);

    }

}
