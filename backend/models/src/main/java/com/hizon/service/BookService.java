package com.hizon.service;
import java.util.List;
import com.hizon.model.Book;

public interface BookService {
    List<Book> readAll() throws Exception;
    void create(Book book) throws Exception;
    Book read(Integer id) throws Exception;
    void update(Book book) throws Exception;
    void delete(Integer id) throws Exception;
}
