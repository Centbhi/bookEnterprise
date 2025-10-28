package com.hizon.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.hizon.model.User;
import com.hizon.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getAllStatuss(){
        try{
            return ResponseEntity.ok(userService.readAll());
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStatus(@PathVariable("id") final Integer id){
        try{
            return ResponseEntity.ok(userService.read(id));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> postStatus(@RequestBody User user){
        try{
            return ResponseEntity.ok(userService.create(user));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> putStatus(@PathVariable("id") final Integer id, @RequestBody User user){
        try{
            return ResponseEntity.ok(userService.update(id,user));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStatus(@PathVariable("id") final Integer id){
        try{
            userService.delete(id);
            return ResponseEntity.noContent().build();
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

}