package com.order.order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/{oid}")
    public Order getOrder(@PathVariable int oid){

        RestTemplate rt = new RestTemplate();

        User user = rt.getForObject("http://localhost:8080/users/2",User.class);

        return new Order(oid,"Laptop",60000,user);
    }
}
