package com.example.formulazero.Controller;

import com.example.formulazero.Model.User;
import com.example.formulazero.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/auth/")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * Creates a user using the UserService class.
     * @param userObject The information being used to create the user.
     * @return A new User created.
     */
    @PostMapping(path = "/register/")
    @ResponseStatus(HttpStatus.CREATED)
    public User registerNewUser(@RequestBody User userObject) {
        return userService.registerNewUser(userObject);
    }
}
