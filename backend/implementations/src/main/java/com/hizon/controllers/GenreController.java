package com.hizon.controllers;

import org.springframework.web.bind.annotation.*;
import com.hizon.model.Genre;
import com.hizon.service.GenreService;

@RestController
@RequestMapping("/api/genre")
public class GenreController extends GenericController<Genre>{
    public GenreController(GenreService service){
        super(service);
    }
}