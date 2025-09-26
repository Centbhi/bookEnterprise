package com.hizon.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.hizon.model.Status;
import com.hizon.service.StatusService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/status")
public class StatusController {
    @Autowired
    private StatusService statusService;

    @GetMapping
    public ResponseEntity<?> getAllStatuss(){
        try{
            return ResponseEntity.ok(statusService.readAll());
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStatus(@PathVariable("id") final Integer id){
        try{
            return ResponseEntity.ok(statusService.read(id));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> postStatus(@RequestBody Status status){
        try{
            return ResponseEntity.ok(statusService.create(status));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> putStatus(@PathVariable("id") final Integer id, @RequestBody Status status){
        try{
            return ResponseEntity.ok(statusService.update(id,status));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStatus(@PathVariable("id") final Integer id){
        try{
            statusService.delete(id);
            return ResponseEntity.noContent().build();
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

}