package com.hizon.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.hizon.model.Genre;
import com.hizon.service.GenreService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/genre")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @GetMapping
    public ResponseEntity<?> getAllGenres(){
        try{
            return ResponseEntity.ok(genreService.readAll());
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGenre(@PathVariable("id") final Integer id){
        try{
            return ResponseEntity.ok(genreService.read(id));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> postGenre(@RequestBody Genre genre){
        try{
            return ResponseEntity.ok(genreService.create(genre));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> putGenre(@PathVariable("id") final Integer id, @RequestBody Genre genre){
        try{
            return ResponseEntity.ok(genreService.update(id,genre));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGenre(@PathVariable("id") final Integer id){
        try{
            genreService.delete(id);
            return ResponseEntity.noContent().build();
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

}