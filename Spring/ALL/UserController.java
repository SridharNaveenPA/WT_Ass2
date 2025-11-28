package com.webtech.demo;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")   // Base URL
public class UserController {

    // Temporary in-memory list (acts like a database)
    List<User> users = new ArrayList<>();

    // ---------- GET (List all users) ----------
    @GetMapping
    public List<User> getAllUsers() {
        return users;
    }

    // ---------- GET (Fetch specific user by ID) ----------
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {

        for (User u : users) {
            if (u.getId() == id) {
                return u;   // return the matching user
            }
        }

        return null; // return null if no user found
    }


    // ---------- POST (Add new user) ----------
    @PostMapping
    public User createUser(@RequestBody User user) {
        users.add(user);
        return user;   // Return same user details
    }

    // ---------- PUT (Update whole user) ----------
    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User newData) {
        for (User u : users) {
            if (u.getId() == id) {
                u.setName(newData.getName());
                u.setEmail(newData.getEmail());
                return u;
            }
        }
        return null; // user not found
    }

    // ---------- DELETE (Remove user) ----------
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        users.removeIf(u -> u.getId() == id);
        return "User with id " + id + " deleted.";
    }
}
