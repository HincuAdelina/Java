package com.fmiunibuc.ProiectJava.controllers;

import com.fmiunibuc.ProiectJava.entities.Product;
import com.fmiunibuc.ProiectJava.services.ProductService;
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
public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @Test
    public void getProductsByRestaurantIdTest() {
        int restaurantId = 1;
        when(productService.getProductsByRestaurantId(restaurantId)).thenReturn(Arrays.asList(new Product("Burger", "Delicious", 10, "Fast Food")));

        ResponseEntity<List<Product>> response = productController.getProductsByRestaurantId(restaurantId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
    }

    @Test
    public void addProductTest() {
        int restaurantId = 1;
        Product product = new Product("Pizza", "Tasty", 15, "Italian");
        when(productService.addProduct(product, restaurantId)).thenReturn(product);

        ResponseEntity<Product> response = productController.addProduct(product, restaurantId);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(product, response.getBody());
    }

//    @Test
//    public void updateProductTest() {
//        int productId = 1;
//        Product updatedProduct = new Product("Updated Burger", "More Delicious", 12, "Fast Food");
//        Product mockProduct = new Product("Burger", "Delicious", 10, "Fast Food");
//        when(productService.getProductById(productId)).thenReturn(mockProduct);
//
//        ResponseEntity<Product> response = productController.updateProduct(productId, updatedProduct);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(updatedProduct.getName(), response.getBody().getName());
//    }

    @Test
    public void removeProductTest() {
        int productId = 1;

        ResponseEntity<HttpStatus> responseEntity = productController.removeProduct(productId);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }


}
