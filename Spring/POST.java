package com.webtech.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @PostMapping("/createUser")
    public String createUser(@RequestBody User user) {
        return "User Created: " + user.getName() + " (Age: " + user.getAge() + ")";
    }
}
