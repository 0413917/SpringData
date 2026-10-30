package org.example.Controller;


import org.example.Service.UserService;
import org.example.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {


@Autowired                         //field injection
    private UserService userService;

@PostMapping( name = "add")
    public User add(@RequestBody User user){
        return userService.add(user);
    }


 }
