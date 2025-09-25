package com.hizon.services;
import java.util.List;
import com.hizon.model.Book;

public interface BookService {
    List<Book> readAll() throws Exception;
    Book create(Book book) throws Exception;
    Book read(Integer id) throws Exception;
    Book update(Book book) throws Exception;
    void delete(Integer id) throws Exception;
}
