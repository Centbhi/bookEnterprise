package com.hizon.controllers;

import com.hizon.model.User;
import com.hizon.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController extends GenericController<User>{
    
    private final UserService service;
    public UserController (UserService service){
        super(service);
        this.service = service;
    }

    @GetMapping("/name/{username}")
    public User findByName (@PathVariable String username){
        return service.findByName(username);
    }

}