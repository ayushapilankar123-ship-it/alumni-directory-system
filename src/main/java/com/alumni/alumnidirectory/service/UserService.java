package com.alumni.alumnidirectory.service;

import com.alumni.alumnidirectory.model.User;
import com.alumni.alumnidirectory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // REGISTER USER
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    // LOGIN USER
    public User loginUser(String email, String password) {

        User user = userRepository.findByEmail(email);

        if(user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }

    // GET ALL USERS
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // UPDATE USER
    public User updateUser(Long id, User updatedUser) {

        User user = userRepository.findById(id).orElse(null);

        if(user != null) {

            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            user.setGraduationYear(updatedUser.getGraduationYear());
            user.setCompany(updatedUser.getCompany());
            user.setJobRole(updatedUser.getJobRole());

            return userRepository.save(user);
        }

        return null;
    }

    // DELETE USER
    public void deleteUser(Long id) {

        userRepository.deleteById(id);
    }
}