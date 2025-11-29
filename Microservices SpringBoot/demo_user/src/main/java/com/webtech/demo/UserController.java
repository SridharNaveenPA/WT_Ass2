package com.webtech.demo;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    List<User> u = new ArrayList<>();

    @GetMapping
    public List<User> getAllUsers(){
        return u;
    }

//    @GetMapping("/param")
//    public User getByIDD(@RequestParam int id){
//        for(User i : u){
//            if(i.getId()==id){
//                return i;
//            }
//        }
//        return  null;
//    }
    @GetMapping("/{id}")
    public User getById(@PathVariable int id){
        for(User i : u){
            if(i.getId()==id){
                return i;
            }
        }
        return  null;
    }

    @PostMapping
    public User createUser(@RequestBody User x){
        u.add(x);
        return x;
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable int id,@RequestBody User x){
        for(User i : u){
            if(i.getId()==id){
                i.setName(x.getName());
                i.setEmail(x.getEmail());
            }
        }
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id){
        int pos = -1;
        for (int j = 0; j < u.size(); j++) {
            if (u.get(j).getId() == id) {
                pos = j;
                break;
            }
        }

        if (pos == -1) {
            return "User not found";
        }

        u.remove(pos);
        return "User with id " + id + " removed";
    }


}