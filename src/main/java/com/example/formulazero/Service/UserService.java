package com.example.formulazero.Service;

import com.example.formulazero.Model.User;
import com.example.formulazero.Repository.UserRepository;
import com.example.formulazero.exceptions.InformationExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Creates a new User and saves the user to database.
     * @param userObject The information being used to create the user,
     * @return A newly created User.
     */
    public User registerNewUser(User userObject) {
        if(userObject.getEmail().equals(userRepository.findByEmail(userObject.getEmail()))) {
            throw new InformationExistsException("A user with this email already exists. Please use a different on.");
        } else {
            return userRepository.save(userObject);
        }
    }
}
