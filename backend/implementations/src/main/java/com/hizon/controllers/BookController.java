package com.hizon.controllers;

import com.hizon.model.Book;
import com.hizon.service.BookService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
public class BookController extends GenericController<Book>{
    public BookController(BookService bookService){
        super(bookService);
    }
}