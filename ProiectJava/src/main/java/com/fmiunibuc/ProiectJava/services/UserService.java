package com.fmiunibuc.ProiectJava.services;
import com.fmiunibuc.ProiectJava.entities.User;

import java.util.List;

public interface UserService {

    User getUserById(int id);

    List<User> getUserList();

    User addUser(User user);

    void updateUser(int id, User user);

    void removeUser(int id);
}
