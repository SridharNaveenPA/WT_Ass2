package com.webtech.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return "OOMBBUU " + name;
    }

    @GetMapping("/welcome")
    public String welcome(@RequestParam(defaultValue = "Guest") String name) {
        return "Hello " + name;
    }

}
