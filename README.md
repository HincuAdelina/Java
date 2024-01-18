# Java

### Baza de date PostgreSQL
![Untitled](https://github.com/HincuAdelina/Java/assets/80088876/74d1da95-6d3a-4a0f-b8aa-9f0eb48f7951)

### Controllers
USER:  
1. Afisare utilizator dupa id.  
2. Afisare toti utilizatorii.  
3. Actualizare utilizator.  
4. Adaugare utilizator.  

RESTAURANT:  
5. Afisare restaurant dupa id.  
6. Afisare toate restaurantele.  
7. Actualizare restaurant.  
8. Adaugare restaurant.  

PRODUS:  
9. Afisare toate produsele unui restaurant dupa restaurant_id.  
10. Adaugarea unui produs la un restaurant dupa restaurant_id.  
11. Actualizare produs.  
12. Stergere produs.  

ORDER:  
13. Afisare comenzi dupa restaurant_id.  
14. Afisare comenzi dupa user_id.  
15. Afisare comenzi dupa driver_id.  
16. Afisare toate produsele dintr-o comanda.  
17. Adaugare comanda asignata unui restaurant, unui utilizator si unui sofer.  
18. Adaugare produs nou la comanda folosind user_id. Pretul total se actualizeaza.  
19. Stergere produs dint-o comanda existenta folosind product_id. Pretul total se actualizeaza.  
20. Actualizare comanda.  
21. Stergere comanda.  

DRIVER:  
22. Afisare soferi care apartin de un restaurant dupa restaurant_id.  
23. Adaugare sofer la un restaurant dupa restaurant_id.  
24. Actualizare sofer.  
25. Stergere sofer.  

### Services
DriverService, OrderService, ProductService, RestaurantService, UserService  

### Business requirements, MVP
1. Se poate initia o comanda la care se pot adauga sau din care se pot elimina produse. Comenzile pot fi vizualizate in functie de utilizator, restaurant sau sofer. Ele pot fi sterse sau modificate. Este posibil sa se selecteze toate produsele care apartin unei comenzi specifice.
2. In aplicatie pot fi adaugati utilizatori, iar datele acestora pot fi modificate. Se pot selecta detaliile unui utilizator specific sau se poate obține o lista de utilizatori. De asemenea, exista posibilitatea stergerii unui utilizator.
3. Este posibila adaugarea de soferi care sa apartina unui anumit restaurant in aplicatie. Soferii pot fi selectati in functie de restaurant, editati sau stersi conform nevoilor.
4. In aplicatie, exista posibilitatea de a adauga restaurante, iar datele acestora pot fi modificate. Se pot selecta detaliile unui restaurant specific sau se poate obtine o lista de restaurante. In plus, un restaurant poate fi sters.
5. Se pot introduce produse care sunt asociate cu un anumit restaurant. Aceste produse pot fi selectate in functie de restaurant, modificate sau eliminate.

### Tests
![image](https://github.com/HincuAdelina/Java/assets/80088876/2b127f86-4dad-4d75-81b1-c3edb8e93948)

Test coverage  
![image](https://github.com/HincuAdelina/Java/assets/80088876/5e94e51b-e215-4787-8dc7-80b306d5e33e)


### Swagger

![image](https://github.com/HincuAdelina/Java/assets/80088876/f78d49cc-d9db-4923-8c94-0f521c12f89c)

```@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Proiect Java")
                        .description("Master IS"));
    }
}
```




