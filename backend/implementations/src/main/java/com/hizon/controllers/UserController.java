package com.hizon.controllers;

import com.hizon.model.User;
import com.hizon.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController extends GenericController<User>{
    public UserController (UserService service){
        super(service);
    }
}