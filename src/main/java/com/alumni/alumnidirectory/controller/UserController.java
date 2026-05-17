package com.alumni.alumnidirectory.controller;

import com.alumni.alumnidirectory.model.User;
import com.alumni.alumnidirectory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    // REGISTER API
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    // LOGIN API
    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {

        User validUser = userService.loginUser(user.getEmail(), user.getPassword());

        if(validUser != null) {
            return "Login Successful";
        }

        return "Invalid Email or Password";
    }

    // GET ALL USERS API
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // UPDATE USER API
    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Long id,
                           @RequestBody User user) {

        return userService.updateUser(id, user);
    }

    // DELETE USER API
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);

        return "User Deleted Successfully";
    }

    // TEST API
    @GetMapping("/test")
    public String testApi() {
        return "API is working";
    }
}