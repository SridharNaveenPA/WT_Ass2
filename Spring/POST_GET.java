package com.webtech.demo;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    private List<User> userList = new ArrayList<>();

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        userList.add(user);
        return user;  // return the saved user
    }

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return userList;  // return all users added so far
    }
}
