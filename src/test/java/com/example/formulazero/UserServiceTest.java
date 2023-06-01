package com.example.formulazero;

import com.example.formulazero.Model.User;
import com.example.formulazero.Service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    @DisplayName("Should create a new user")
    public void shouldCreateANewUser() {
        User newUser = new User(4L, "hellohey@gmail.com", "password", "Gio Dani");
        userService.createNewUser(newUser);
    }
}
