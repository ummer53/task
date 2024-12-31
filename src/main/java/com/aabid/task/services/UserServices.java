package com.aabid.task.services;



import com.aabid.task.models.User;
import com.aabid.task.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UserRepo userRepository;

    // Create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Update an existing user
    public User updateUser(Long id, User userDetails) {
        if (userRepository.existsById(id)) {
            userDetails.setId(id);
            return userRepository.save(userDetails);
        } else {
            return null;
        }
    }

    // Delete a user by ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

