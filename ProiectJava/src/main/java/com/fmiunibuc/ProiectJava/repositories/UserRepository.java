package com.fmiunibuc.ProiectJava.repositories;

import com.fmiunibuc.ProiectJava.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
