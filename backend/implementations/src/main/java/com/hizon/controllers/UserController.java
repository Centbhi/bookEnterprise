package com.hizon.controllers;

import com.hizon.model.LoginRequest;
import com.hizon.model.User;
import com.hizon.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@RequestMapping("/api/user")
public class UserController extends GenericController<User>{
    
    private final UserService service;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserController (UserService service){
        super(service);
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody LoginRequest req){
        User user = service.findByName(req.getName());
        if(passwordEncoder.matches(req.getPassword(), user.getPassword())){
            user.setPassword(null);
            return ResponseEntity.ok(user);
        }else {
            Map<String, String> body = new HashMap<>();
            body.put("message", "Invalid Password");
            return ResponseEntity.badRequest().body(body);
        }
    }
}